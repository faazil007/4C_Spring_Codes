.MODEL SMALL
.STACK 100H
.CODE
    MAIN PROC
        MOV BX, 9ABFh
        MOV CX, 4
        MOV AH, 2
        
    PRINT:
        MOV DL, BH
        SHR DL, 1
        SHR DL, 1
        SHR DL, 1
        SHR DL, 1
        
        CMP DL, 9
        JLE DISPNUM
        ADD DL,55        
        JMP DISP  
      
    DISPNUM:
        ADD DL, 48    
    
    DISP:
        INT 21H
        ROL BX,1
        ROL BX,1
        ROL BX,1
        ROL BX,1
        LOOP PRINT    
    
        MOV AH, 4CH
        INT 21H        
    MAIN  ENDP
   END   MAIN
