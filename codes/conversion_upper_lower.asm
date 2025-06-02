        ; Input a Capital Letter Convert it to It's Equivalent Small letter
.DATA
    MSG1 DB 'Enter a Small Letter(a--z) : $'
    MSG2 DB 0AH,0DH,'Equivalent Capital Letter = $'
    MSG3 DB 0AH,0DH,'Try again...Character must range from a--z$'
    NL DB 0AH, 0DH, '$'
    
.CODE
    START:
        
        MOV AX, @DATA
        MOV DS, AX
        
        AGAIN:
            
            MOV DX,offset MSG1
            MOV AH, 9
            INT 21H
            
            MOV AH, 1
            INT 21H
            
            CMP AL, 'a'
            JB ERROR
            
            CMP AL, 'z'
            JA ERROR
            
            SUB AL, 20H
            MOV BL, AL
            
            MOV DX, offset MSG2
            MOV AH, 9
            INT 21H
            
            MOV DL, BL
            MOV AH, 2
            INT 21H
            
            JMP QUIT
            
            ERROR:
                
                MOV DX,offset MSG3
                MOV AH, 9
                INT 21H
                
                MOV DX, offset NL
                INT 21H
                
                JMP AGAIN
            
            QUIT:
                
                MOV AH, 4CH
                INT 21H
                END START