.MODEL SMALL
.STACK 100H
.CODE
    MAIN PROC
       XOR BX, BX
       MOV CL, 4
       MOV AH, 1       
    INPUT:
        INT 21H
        CMP AL,13
        
        JE END_INPUT
        SHL BX, CL
        CMP AL, '9'
        
        JLE NUMBER
        SUB AL, 55
        JMP INSERT
        
    NUMBER:
        SUB AL, 48        
    INSERT:
        OR BL, AL
        JMP INPUT
        
    END_INPUT:
        MOV AH, 4CH
        INT 21H
        
    MAIN  ENDP
   END   MAIN
