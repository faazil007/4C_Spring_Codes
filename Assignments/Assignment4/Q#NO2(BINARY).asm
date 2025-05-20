.MODEL SMALL
.STACK 100H
.DATA
    MENU DB 10, 13, "***SELECT OPERATION***",
             DB 10, 13, "1. ADDITION",
             DB 10, 13, "2. SUBTRACTION",
             DB 10, 13, "3. MULTIPLICATION",
             DB 10, 13, "4. DIVISION(REMAINDER)",
             DB 10, 13, "5. DIVISION(QUOTIENT)",
             DB 10, 13, "6. EXIT$"
    MSG1 DB 10, 13, "PLEASE INPUT A VALID DIGITAL CHARACTER...PRESS ANY KEY TO CONTINUE...$"
    MSG2 DB 10, 13, "ENTER FIRST VALUE(BINARY):$"
    MSG3 DB 10, 13, "ENTER SECOND VALUE(BINARY):$"
    MSG4 DB 10, 13, "RESULT = $"
    MSG5 DB 10, 13, "PRESS ANY KEY TO CONTINUE...$"
    OP1 DW ?
    OP2 DW ?
    ADD_OPR DB "+$"
    SUB_OPR DB "-$"
    MUL_OPR DB "*$"
    REM_OPR DB "%$"
    QUO_OPR DB "/$"
    EQUALS DB "=$"
    TEMP DB ?
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        START:
            
            LEA DX, MSG2
            CALL STR_DIS
            CALL BIN_INP
            MOV OP1, AX
                       
            LEA DX, MSG3
            CALL STR_DIS
            CALL BIN_INP
            MOV OP2, AX
            
            PROCESS:
                LEA DX, MENU
                CALL STR_DIS
                
                CALL NEW_LINE
                CALL CHAR_INP
                MOV BL, TEMP
                
                CMP BL, '1'
                JZ ADDITION
                
                CMP BL, '2'
                JZ SUBTRACTION
                
                CMP BL, '3'
                JZ MULTIPLICATION
                
                CMP BL, '4'
                JZ DIV_REM
                
                CMP BL, '5'
                JZ DIV_QUO
                
                CMP BL, '6'
                JZ QUIT
                
                JNZ ERROR
                
                ADDITION:               
                    CALL NEW_LINE
                    MOV AX, OP1
                    CALL BIN_OUT
                    LEA DX, ADD_OPR
                    CALL STR_DIS
                    MOV AX, OP2
                    CALL BIN_OUT
                    LEA DX, EQUALS
                    CALL STR_DIS
                    
                    MOV BX, OP1
                    ADD BX, OP2
                    
                    MOV AX, BX
                    CALL BIN_OUT
                    
                    LEA DX, MSG5
                    CALL STR_DIS
                    CALL CHAR_INP
                    
                    JMP START
     
                SUBTRACTION:
                    CALL NEW_LINE
                    MOV AX, OP1
                    CALL BIN_OUT
                    LEA DX, SUB_OPR
                    CALL STR_DIS
                    MOV AX, OP2
                    CALL BIN_OUT
                    LEA DX, EQUALS
                    CALL STR_DIS
                    
                    MOV BX, OP1
                    SUB BX, OP2
                    
                    MOV AX, BX
                    CALL BIN_OUT
                    
                    LEA DX, MSG5
                    CALL STR_DIS
                    CALL CHAR_INP
                    
                    JMP START
                
                MULTIPLICATION:
                    CALL NEW_LINE
                    MOV AX, OP1
                    CALL BIN_OUT
                    LEA DX, MUL_OPR
                    CALL STR_DIS
                    MOV AX, OP2
                    CALL BIN_OUT
                    LEA DX, EQUALS
                    CALL STR_DIS
                    
                    MOV AX, OP1
                    MUL OP2
                    
                    CALL BIN_OUT
                    
                    LEA DX, MSG5
                    CALL STR_DIS
                    CALL CHAR_INP
                    
                    JMP START
                
                DIV_REM:
                    CALL NEW_LINE
                    MOV AX, OP1
                    CALL BIN_OUT
                    LEA DX, REM_OPR
                    CALL STR_DIS
                    MOV AX, OP2
                    CALL BIN_OUT
                    LEA DX, EQUALS
                    CALL STR_DIS
                    
                    MOV AX, 0
                    MOV DX, 0
                    MOV AX, OP1
                    DIV OP2
                    MOV AX, 0
                    MOV AX, DX
                    
                    CALL BIN_OUT
                    
                    LEA DX, MSG5
                    CALL STR_DIS
                    CALL CHAR_INP
                    
                    JMP START
                
                DIV_QUO:
                    CALL NEW_LINE
                    MOV AX, OP1
                    CALL BIN_OUT
                    LEA DX, QUO_OPR
                    CALL STR_DIS
                    MOV AX, OP2
                    CALL BIN_OUT
                    LEA DX, EQUALS
                    CALL STR_DIS
                    
                    MOV AX, 0
                    MOV DX, 0
                    MOV AX, OP1
                    DIV OP2
                    
                    CALL BIN_OUT
                    
                    LEA DX, MSG5
                    CALL STR_DIS
                    CALL CHAR_INP
                    
                    JMP START
                
                ERROR:
                    LEA DX, MSG1
                    CALL STR_DIS
                    CALL CHAR_INP
                    JMP PROCESS
                
                JMP QUIT
            
        QUIT:
            MOV AH, 4CH
            INT 21H
    MAIN ENDP
    
    CHAR_INP PROC
        
        MOV AH, 1
        INT 21H
        MOV TEMP, AL
        
        RET
    CHAR_INP ENDP
    
    CHAR_OUT PROC
        MOV AH, 2
        INT 21H
        
        RET
    CHAR_OUT ENDP
    
    BIN_INP PROC
        MOV BX, 0
        MOV CX, 2
        
        AGAIN1:
            CALL CHAR_INP
            MOV AL, TEMP
            
            CMP AL, '0'
            JB DONE_INP
            
            CMP AL, '1'
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
            
        RET
    BIN_INP ENDP
    
    BIN_OUT PROC
        MOV BX, 2
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
        
        RET
    BIN_OUT ENDP
    
    NEW_LINE PROC
        MOV AH, 2
        MOV DL, 0DH
        INT 21H
        
        MOV AH,2
        MOV DL, 0AH
        INT 21H
        
        RET
    NEW_LINE ENDP
    
    STR_DIS PROC
        MOV AH, 9
        INT 21H
        
        RET
    STR_DIS ENDP