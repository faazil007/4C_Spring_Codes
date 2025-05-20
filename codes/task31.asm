.STACK 100H
.DATA
    BARRAY DB 5,1110B,'C', ?       ; 4 = 4 X 1
    WARRAY DW 1234H, ?, 5678H      ; 6 = 3 X 2 ; 18 BYTES
    DARRAY DD 12345678H, 11223344H ; 8 = 2 X 4


.CODE
    MAIN PROC
        MOV AX,@DATA
        MOV DS,AX
        ;---------------------------
         
        MOV AL,BARRAY
        MOV BL,BARRAY + 1
        MOV CL,BARRAY + 3
        MOV DL,BARRAY + 9
        
        MOV AX,WARRAY
        MOV BX,WARRAY + 2
        MOV CX,WARRAY + 3
        MOV DX,WARRAY + 12
        
        MOV AX,DARRAY
        MOV AX, WORD PTR DARRAY ; TYPE CASTING
        
         
        
        
        
        
        
        
        
        
        ;---------------------------
        MOV AH,4CH
        INT 21H
        MAIN ENDP
    END MAIN
        
      