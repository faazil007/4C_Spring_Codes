.STACK

.DATA

.CODE
    MAIN PROC
         
        ;---------------
        XOR BX, BX
        MOV AH, 1
        
INPUT:
        INT 21H
        CMP AL, 13
        JE END_INPUT

        SHL BX, 1
        SUB AL, 48
        OR BL, AL
        JMP INPUT
        ;----------------
END_INPUT:
        
    MOV AH, 4CH
    INT 21H
    MAIN ENDP
END MAIN