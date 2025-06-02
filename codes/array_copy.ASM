.STACK 100H
.DATA
;----------------------------------------
    MESSAGE1 DB , 0DH,0AH, "Enter a Decimal Value :$"
    MESSAGE2 DB , 0DH,0AH, "The Original Array :$"
    MESSAGE3 DB , 0DH,0AH, "The copied Array :$"
    TEMPORARY DB ?
    
    SOURCE_ARRAY DB 5 DUP(?)
    
    DESTINATION_ARRAY DB 5 DUP(?)


;----------------------------------------
.CODE
    MAIN PROC
        MOV AX,@DATA
        MOV DS,AX  
        ;------------------------------------
        ;Input Values into Source Array
        ;------------------------------------
        
        MOV CX,5 ; Counter
        MOV SI,0
        
        INPUT_AGAIN:
        MOV DX, OFFSET MESSAGE1
        CALL STRING_DISPLAY
        CALL DECIMAL_INPUT
        MOV SOURCE_ARRAY[SI] ,AL  ; To get a decimal value from keyboard, return it in AX
        ADD SI,1 ; To index to the next element
        LOOP INPUT_AGAIN
        
        
        
        ;-----------------------------------------------
        ;Copying the source array into Destination array
        ;-----------------------------------------------
        
        MOV CX, 5
        MOV SI,0 ; To be used for source indexing
        MOV DI,0 ; To be used for destination indexing
        
        INPUT_AGAIN_2:
        MOV AL,SOURCE_ARRAY[SI]
        MOV DESTINATION_ARRAY[DI],AL
        ADD SI,1
        ADD DI,1
        LOOP INPUT_AGAIN_2
        
        ;-----------------------------------------------
        ; Displaying the Source Array
        ;-----------------------------------------------
        MOV DX, OFFSET MESSAGE2
        CALL STRING_DISPLAY
        
        MOV CX,5 ; Counter
        MOV SI,0  ; For Indexing
        
        DISPLAY_SOURCE:
        MOV AL,SOURCE_ARRAY[SI]
        
        XOR AH,AH
        CALL DECIMAL_OUTPUT
        
        MOV DL,','
        CALL CHARACTER_OUTPUT
        ADD SI,1
        LOOP DISPLAY_SOURCE
        
        ;-----------------------------------------------
        ; Displaying the Destination Array
        ;-----------------------------------------------
        
        MOV DX, OFFSET MESSAGE3
        CALL STRING_DISPLAY
        
        MOV CX,5 ; Counter
        MOV SI,0  ; For Indexing
        
        DISPLAY_DESTINATION:
        MOV AL,DESTINATION_ARRAY[DI]
        
        XOR AH,AH
        CALL DECIMAL_OUTPUT
        
        MOV DL,','
        CALL CHARACTER_OUTPUT
        ADD DI,1
        LOOP DISPLAY_DESTINATION
        
        
        
        
        
        JMP QUIT
        
        
        
        
        
        
        
        
        
        
        QUIT:
        MOV AH,4CH
        INT 21H
        MAIN ENDP
    
    
    
    
    
    
    
    
    
    
    
;--------------------------------    
; 1st Proc    
;--------------------------------    
    CHARACTER_INPUT PROC
        MOV AH,1
        INT 21H
        MOV TEMPORARY,AL
        
        RET
      
    CHARACTER_INPUT ENDP
;--------------------------------    

;--------------------------------
; 2nd Proc
;--------------------------------    
    CHARACTER_OUTPUT PROC
        MOV AH,2
        INT 21H
        
        RET
        
    CHARACTER_OUTPUT ENDP    

;--------------------------------
; 3rd Proc
;--------------------------------
    STRING_DISPLAY PROC
        MOV AH,9
        INT 21H
        
        RET
    STRING_DISPLAY ENDP
       
;--------------------------------
; 4th Proc
;--------------------------------
    DECIMAL_INPUT PROC
        MOV BX,0
        MOV CX,10
        
        INPUT_DEC1:
            CALL CHARACTER_INPUT
            MOV AL,TEMPORARY
            
            CMP AL,'0'
            JB INPUT_DEC2
            
            CMP AL,'9'
            JA INPUT_DEC2
            
            SUB AL,'0'
            MOV AH,0
            PUSH AX
            MOV AX,BX
            MUL CX
            POP BX
            ADD BX,AX
            JMP INPUT_DEC1
            
        
        
        INPUT_DEC2:
            MOV AX,BX
            
        
        RET
        
    DECIMAL_INPUT ENDP            
    
;--------------------------------
; 5th Proc
;--------------------------------
    DECIMAL_OUTPUT PROC
        MOV BX,10
        MOV CX,0   
        
        OUTPUT_DEC1:
            MOV DX,0
            DIV BX
            PUSH DX
            INC CX
            CMP AX,0
            JNZ OUTPUT_DEC1
        
            
        DISPLAY_DIGITS:
            POP DX
            ADD DX,'0'
            CALL CHARACTER_OUTPUT
            LOOP DISPLAY_DIGITS
        
        RET
        
     DECIMAL_OUTPUT ENDP
      