.STACK 100H
.DATA
;-------------------------------
    MATRIXA DW 10,20,30
            DW 40,50,60
            DW 70,80,90
            
    MATRIXB DW 11,12,13
            DW 21,22,23
            DW 31,32,33
    
    TEMP DB ?                
;-------------------------------    
.CODE
;-------------------------------
;---------------------------------
; Decimal Input Output Procedures 
;---------------------------------
DEC_INP PROC
        PUSH BX
        PUSH CX
        PUSH DX
        
        MOV BX, 0
        MOV CX, 10
        
        AGAIN1:
            CALL CHAR_INP
            MOV AL, TEMP
            
            CMP AL, '0'
            JB DONE_INP
            
            CMP AL, '9'
            JA DONE_INP
            
            SUB AL, '0'
            
            MOV AH, 0
            
            PUSH AX
            
            MOV AX, BX
            
            MUL CX
            
            POP BX
            
            ADD BX, AX
            
            JMP AGAIN1
            
        DONE_INP:
            MOV AX, BX
            
        POP DX
        POP CX
        POP BX
            
        RET
    DEC_INP ENDP
    
    DEC_OUT PROC
        PUSH AX
        PUSH BX
        PUSH CX
        PUSH DX
        
        MOV BX, 10
        MOV CX, 0
        AGAIN2:        
            MOV DX, 0
            
            DIV BX
            
            PUSH DX
            
            INC CX
            
            CMP AX, 0
        
            JNZ AGAIN2
            
        DISPLAY:
            POP DX
            
            ADD DX, '0'
            
            CALL CHAR_OUT
            
            LOOP DISPLAY 
        
        POP DX
        POP CX
        POP BX
        POP AX
        RET
    DEC_OUT ENDP
    
    CHAR_INP PROC
        MOV AH, 1
        INT 21H
        MOV TEMP, AL
        
        RET
    CHAR_INP ENDP
    
    CHAR_OUT PROC
        MOV AH,2
        INT 21H
        
        RET
    CHAR_OUT ENDP    
    
    
    
    


;---------------------------------
MAIN PROC
    MOV AX,@DATA
    MOV DS,AX
;---------------------------------
    CALL DEC_INP
    MOV MATRIXA[0][2],AX
    
    ;-------------------------------------------------------------
    ; Printing the Values of First Row Using BASE_Index Addressing
    ;-------------------------------------------------------------
    MOV CX,3  ;Display the Row Elements
    MOV BX,0  ;Place the row starting Address in BX
    MOV SI,0
    
    NEXT_COLUMN:
    MOV AX, A[BX][SI]
    CALL DEC_OUT
    
    ADD SI,2
    LOOP NEXT_COLUMN  
    
    
    
    
    
    
    
    JMP QUIT
    QUIT:
    MOV AH,4CH
    INT 21H
    
    MAIN ENDP
END MAIN
;-------------------------------                             