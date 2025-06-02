.DATA
    MSG1 DB 'Enter a Capital Letter(A--Z) : $'
    MSG2 DB 0AH,0DH,'Equivalent Small Letter = $'
    MSG3 DB 0AH,0DH,'Try again...Character must range from A--Z$'
    NL DB 0AH, 0DH, '$'
.CODE
    START:
        
        MOV AX, @DATA
        MOV DS, AX
        MOV CX, 5
        
        AGAIN:
            
            MOV DX,offset  MSG1
            MOV AH, 9
            INT 21H
            
            MOV AH, 1
            INT 21H
            
            CMP AL, 'A'
            JB ERROR
            
            CMP AL, 'Z'
            JA ERROR
            
            ADD AL, 20H
            MOV BL, AL
            
            LEA DX, MSG2
            MOV AH, 9
            INT 21H
            
            MOV DL, BL
            MOV AH, 2
            INT 21H
            
            LEA DX, NL
            MOV AH, 9 
            INT 21H
            
            DEC CX
            CMP CX, 0
            JNE AGAIN
            
            JMP QUIT
            
            ERROR:
                
                LEA DX, MSG3
                MOV AH, 9
                INT 21H
                
                LEA DX, NL
                INT 21H
                
                JMP AGAIN
            
            QUIT:
                
                MOV AH, 4CH
                INT 21H
                END START