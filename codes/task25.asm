.STACK

.DATA
    MSG1    DB  "PLEASE ENTER CHARACTER: $"  
    MSG2    DB  10,13,"THE NUMBER OF 1 ARE: $"
    MSG3    DB  10,13,"THE NUMBER OF 0 ARE: $"
    CONT    DB  0

.CODE
    MAIN PROC
    MOV AX , @DATA
    MOV DS, AX
    
    ;-----------------
        MOV AH, 9
        LEA DX, MSG1
        INT 21H
        
        MOV AH, 1
        INT 21H
        MOV BL, AL
        
        MOV CX, 8
CHECK:
        ROL BL, 1
        JC  ADDON
        LOOP    CHECK
        JMP EXIT
ADDON:
        INC CONT
        LOOP CHECK 
EXIT:
        MOV AH, 9
        LEA DX, MSG2
        INT 21H
            
        MOV DL, CONT
        ADD DL, 48
        MOV AH, 2
        INT 21H

        MOV AH, 9
        LEA DX, MSG3
        INT 21H   
            
        MOV CL, CONT
        MOV BL, 8  
        SUB BL, CL
        MOV DL, BL
        ADD DL, 48
            
        MOV AH, 2
        INT 21H
    ;------------------
    MOV AH, 4CH
    INT 21H
    
END MAIN    