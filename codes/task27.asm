.stack 100h
.data
    MSG1 DB 0AH,0DH, " SORRY :",'$'
    MSG2 DB 0AH,0DH,  



.CODE
    MAIN PROC
        MOV AX, 0AABBH
        MOV BX, 0CCDDH
        MOV CX, 0EEFFH
        MOV DX, 1234H
        
        PUSH AX
        PUSH BX
        PUSH CX
        PUSH DX         
                       ; When values are pushed in the stack they are popped in the opposite direction 
                       ; Eg values of AX,BX,CX,DX are now placed back oppositely
        
        
        POP AX
        POP BX
        POP CX
        POP DX 
        
        
        MOV AX, 200H
        MOV BX, 20H
        MUL BX
                        ; Multiplication 
        MOV AL,40H
        MOV CL,10H
        MUL CL
        
        
        MOV DX,0008H
        MOV AX,0000H
        MOV CX,400H
        
        DIV CX
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        MAIN ENDP
    END MAIN
        
        
        
    
    
    
    