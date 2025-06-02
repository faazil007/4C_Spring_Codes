.STACK 100H
.DATA
;-----------------------------------------------
    MESSAGE1 DB "ENTER A DECIMAL NUMBER ::$"
    MESSAGE2 DB " ORIGINAL ARRAY :: $"
    MESSAGE3 DB " REVERSED ARRAY :: $"  
    ARRAY1   DW 4 DUP(?)
    ARRAY2   DW 4 DUP(?)
    NEWLINE  DB 0DH,0AH,'$'
    COMMA    DB ",$"
    
    TEMP     DB ?
;-----------------------------------------------
.CODE
    MAIN PROC
        MOV AX,@DATA
        MOV DS,AX 
        
        
      ;-----------------------------------------  
        MOV BX,0
        MOV CX,4
        
        INPUTTING:
            MOV DX,OFFSET MESSAGE1
            CALL STRING_DISPLAY
            CALL HEX_INP
            MOV ARRAY1[BX],AX
            ADD BX,2
            
            MOV DX, OFFSET NEWLINE
            CALL STRING_DISPLAY
            LOOP INPUTTING
      ;-----------------------------------------       
        MOV CX,4
        MOV SI,0
        PUSHING:
            PUSH ARRAY1[SI]
            ADD SI,2
            LOOP PUSHING
            
      ;-----------------------------------------
        MOV CX,4
        MOV DI,0
        POPPING:
            POP ARRAY2[DI]
            ADD DI,2
            LOOP POPPING
            
      ;------------------------------------------
        MOV DX, OFFSET MESSAGE2
        CALL STRING_DISPLAY
            
        MOV CX,4
        MOV BX,0
        
        
        DISPLAYING_ORIGINAL:
            
            MOV AX,ARRAY1[BX]
            CALL HEX_OUT
            ADD BX,2
            
            MOV DX, OFFSET COMMA
            CALL STRING_DISPLAY
            
            LOOP DISPLAYING_ORIGINAL
            
            
      ;-------------------------------------------
        MOV DX, OFFSET NEWLINE
        CALL STRING_DISPLAY
        
        MOV DX, OFFSET MESSAGE3
        CALL STRING_DISPLAY
        
        MOV CX,4
        MOV BX,0
        
        DISPLAYING_REVERSED:
            
            MOV AX,ARRAY2[BX]
            CALL HEX_OUT
            ADD BX,2
            
            MOV DX, OFFSET COMMA
            CALL STRING_DISPLAY
            
            LOOP DISPLAYING_REVERSED
        
        QUIT:
            MOV AH,4CH
            INT 21H    
       ;-------------------------------------------            
            
            RET
         
          MAIN ENDP
    
    
    
DECIMAL_INPUT PROC
    PUSH BX
    PUSH CX
    PUSH DX
    
    MOV BX,0
    MOV CX,10
    
        DEC_1:
            CALL CHARACTER_INPUT
            MOV AL,TEMP
            
            CMP AL,'0' 
            JB DONE_INPUT
            CMP AL,'9'
            JA DONE_INPUT
            
            SUB AL,'0'
            MOV AH,0
            PUSH AX
            MOV AX,BX
            MUL CX
            POP BX 
            ADD BX,AX
            JMP DEC_1
            
            
        DONE_INPUT:
            MOV AX,BX
            
            POP DX
            POP CX
            POP BX
            
    RET
    
DECIMAL_INPUT ENDP 

DECIMAL_OUTPUT PROC
    PUSH BX
    PUSH CX
    PUSH DX
    
    MOV BX,10
    MOV CX,0
    
    
    DEC_OUT_1:
        MOV DX,0
        DIV BX
        INC CX
        CMP AX,0
        JNZ DEC_OUT_1
        
        JMP DISPLAY_DIGITS
        
        DISPLAY_DIGITS:
            POP DX
            ADD DX,'0'
            CALL CHARACTER_OUTPUT
            LOOP DISPLAY_DIGITS
            
    RET
    
DECIMAL_OUTPUT ENDP

CHARACTER_INPUT PROC
    MOV AH,1
    INT 21H
    MOV TEMP,AL
    
    RET
CHARACTER_INPUT ENDP

CHARACTER_OUTPUT PROC
    MOV AH,2
    INT 21H
    
    RET
CHARACTER_OUTPUT ENDP

STRING_DISPLAY PROC
    MOV AH,9
    INT 21H
    
    RET
STRING_DISPLAY ENDP  

HEX_INP PROC
        PUSH BX
        PUSH CX
        PUSH DX        
        
        MOV BX, 0
        MOV CX, 16
    
        AGAIN_7:
            CALL CHARACTER_INPUT
            MOV AL, TEMP
        
            CMP AL, '0'
            JB DONE_INP_4
            CMP AL, '9'
            JBE IS_NUM
        
            CMP AL, 'A'
            JB DONE_INP_4
            CMP AL, 'F'
            JA DONE_INP_4
        
        IS_ALPHA:
            SUB AL, 'A'
            ADD AL, 10
            JMP CONVERT
        
        IS_NUM:
            SUB AL, '0'
        
        CONVERT:
            MOV AH, 0
            PUSH AX
            MOV AX, BX
            MUL CX
            POP BX
            ADD BX, AX
            JMP AGAIN_7
        
        DONE_INP_4:
            MOV AX, BX
            
        POP DX
        POP CX
        POP BX
            RET
        HEX_INP ENDP
    
        
        HEX_OUT PROC
            PUSH AX
            PUSH BX
            PUSH CX
            PUSH DX
            
            MOV BX, 16
            MOV CX, 0
        
            AGAIN_8:
                MOV DX, 0
                DIV BX
                PUSH DX
                INC CX
                CMP AX, 0
                JNZ AGAIN_8
            
            DISPLAY_4:
                POP DX
                CMP DX, 9
                JBE PRINT_DEC
                ADD DL, 'A' - 10
                JMP PRINT_CHAR
            
            PRINT_DEC:
                ADD DL, '0'
            
            PRINT_CHAR:
                CALL CHARACTER_OUTPUT
                LOOP DISPLAY_4 
                
        POP DX
        POP CX
        POP BX
        POP AX
               
        RET
    HEX_OUT ENDP

END MAIN
        