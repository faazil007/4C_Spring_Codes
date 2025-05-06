.STACK

.DATA

.CODE
    MAIN PROC
        
        ;----------------
        MOV BX, 5
        MOV CX, 16
        MOV AH, 2 
PRINT:
        ROL BX, 1
        JC DISPONE
        
        MOV DL, '0'
        INT 21H
        
        LOOP PRINT
        JMP EXIT
DISPONE:
        MOV DL, '1'
        INT 21H
        
        LOOP PRINT

        ;----------------
EXIT:       
    MOV AH, 4CH
    INT 21H
    MAIN ENDP
END MAIN