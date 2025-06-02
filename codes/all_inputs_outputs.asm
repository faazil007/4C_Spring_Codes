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
    
    BIN_INP PROC
        PUSH BX
        PUSH CX
        PUSH DX
        
        MOV BX, 0
        MOV CX, 2
        
        AGAIN_3:
            CALL CHAR_INP
            MOV AL, TEMP
            
            CMP AL, '0'
            JB DONE_INP_2
            
            CMP AL, '1'
            JA DONE_INP_2
            
            SUB AL, '0'
            
            MOV AH, 0
            
            PUSH AX
            
            MOV AX, BX
            
            MUL CX
            
            POP BX
            
            ADD BX, AX
            
            JMP AGAIN_3
            
        DONE_INP_2:
            MOV AX, BX
        
        POP DX
        POP CX
        POP BX
        
        RET
    BIN_INP ENDP
    
    BIN_OUT PROC
        PUSH AX
        PUSH BX
        PUSH CX
        PUSH DX
        
        MOV BX, 2
        MOV CX, 0
        AGAIN_4:        
            MOV DX, 0
            
            DIV BX
            
            PUSH DX
            
            INC CX
            
            CMP AX, 0
        
            JNZ AGAIN_4
            
        DISPLAY_2:
            POP DX
            
            ADD DX, '0'
            
            CALL CHAR_OUT
            
            LOOP DISPLAY_2 
        
        POP DX
        POP CX
        POP BX
        POP AX
        
        RET
    BIN_OUT ENDP
    
    OCT_INP PROC 
        PUSH BX
        PUSH CX
        PUSH DX
        
        MOV BX, 0
        MOV CX, 8
        
        AGAIN_5:
            CALL CHAR_INP
            MOV AL, TEMP
            
            CMP AL, '0'
            JB DONE_INP_3
            
            CMP AL, '7'
            JA DONE_INP_3
            
            SUB AL, '0'
            
            MOV AH, 0
            
            PUSH AX
            
            MOV AX, BX
            
            MUL CX
            
            POP BX
            
            ADD BX, AX
            
            JMP AGAIN_5
            
        DONE_INP_3:
            MOV AX, BX
        POP DX
        POP CX
        POP BX
        
        RET
    OCT_INP ENDP
    
    OCT_OUT PROC
        PUSH AX
        PUSH BX
        PUSH CX
        PUSH DX
        
        MOV BX, 8
        MOV CX, 0
        AGAIN_6:        
            MOV DX, 0
            
            DIV BX
            
            PUSH DX
            
            INC CX
            
            CMP AX, 0
        
            JNZ AGAIN_6
            
        DISPLAY_3:
            POP DX
            
            ADD DX, '0'
            
            CALL CHAR_OUT
            
            LOOP DISPLAY_3 
        
        POP DX
        POP CX
        POP BX
        POP AX
        
        RET
    OCT_OUT ENDP
    
    HEX_INP PROC
        PUSH BX
        PUSH CX
        PUSH DX        
        
        MOV BX, 0
        MOV CX, 16
    
        AGAIN_7:
            CALL CHAR_INP
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
                CALL CHAR_OUT
                LOOP DISPLAY_4 
                
        POP DX
        POP CX
        POP BX
        POP AX
               
        RET
    HEX_OUT ENDP

    
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
    
    