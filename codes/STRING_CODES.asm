;--------------------------------------
;Moving a String using MOVSB Using LOOP
;--------------------------------------
.DATA
    STRING1 DB "HELLO",'$'
    STRING2 DB 5 DUP(?)
    NEWLINE DB 0DH,0AH,'$'
    
.CODE
MAIN PROC
    MOV AX,@DATA
    MOV DS,AX
    MOV ES,AX
    
    
    MOV SI, OFFSET STRING1
    MOV DI, OFFSET STRING2
    CLD
    MOV CX,5
    REPEAT:
    MOVSB
    LOOP REPEAT
    
    MOV DX, OFFSET STRING1
    MOV AH,9
    INT 21H
    
    MOV DX, OFFSET NEWLINE
    MOV AH,9
    INT 21H
    
    MOV DX, OFFSET STRING2
    MOV AH,9
    INT 21H
    
    MOV AH,4CH
    INT 21H
    
    
    
    
    
    MAIN ENDP
END MAIN
    
;--------------------------------------
;Moving a String using MOVSB Using REP 
;--------------------------------------    

.DATA
;---------------------------------
    STRING1 DB "HELLOSAIM",'$'
    STRING2 DB 9 DUP(?)
    NEWLINE DB 0DH,0AH,'$'
;---------------------------------
.CODE
    MAIN PROC
        MOV AX,@DATA
        MOV DS,AX
        MOV ES,AX
        
        CLD
        MOV SI, OFFSET STRING1
        MOV DI, OFFSET STRING2
        
        MOV CX,9
        REP MOVSB
        
        MOV DX, OFFSET STRING1
        MOV AH,9
        INT 21H
        
        MOV DX, OFFSET NEWLINE
        MOV AH,9
        INT 21H
        
        MOV DX, OFFSET STRING2
        MOV AH,9
        INT 21H
        
        MOV AH,4CH
        INT 21H
        
        MAIN ENDP
    END MAIN
            
;--------------------------------------
;Printing reverse of a string 
;--------------------------------------    
.DATA
;--------------------------------
    STRING1 DB "HELLOSAIM",'$'
    STRING2 DB 9 DUP(?)
    NEWLINE DB 0DH,0AH,'$'
;--------------------------------
.CODE
    MAIN PROC
        MOV AX,@DATA
        MOV DS,AX
        MOV ES,AX
        
        MOV SI, OFFSET STRING1 + 8
        MOV DI, OFFSET STRING2
        STD
        MOV CX,9
        MOVE:
        MOVSB
        ADD DI,2
        LOOP MOVE
        
        MOV DX, OFFSET STRING1
        MOV AH,9
        INT 21H
        
        MOV DX, OFFSET NEWLINE
        MOV AH,9
        INT 21H
        
        MOV DX, OFFSET STRING2
        MOV AH,9
        INT 21H
        
        MOV AH,4CH
        INT 21H
        
        MAIN ENDP
    END MAIN   

;----------------------------------------
; Inputting a string and displaying it   
;----------------------------------------
.MODEL SMALL
.STACK 100H
.DATA
    STR DB 20 DUP(?)
.CODE
    MAIN PROC
        MOV AX, @DATA
        MOV DS, AX
        MOV ES, AX
        
        LEA DI, STR
        MOV CX, 0
        MOV AH, 1
        CLD
    INPUT:
        INT 21H
        CMP AL, 13
        JE END_INP
        INC CX
        STOSB
        JMP INPUT
    END_INP:
        MOV DL, 10
        MOV AH, 2
        INT 21H
        MOV DL, 13
        MOV AH, 2
        INT 21H
        
        LEA SI, STR
        CLD
        MOV AH, 2        
    PRINT:
        LODSB
        MOV DL, AL
        INT 21H
        LOOP PRINT        
        MOV AH, 4CH
        INT 21H
      
;--------------------------------------
; Reversing using another technique
;--------------------------------------
.MODEL SMALL
.STACK 100H
.DATA
    STR1 DB "HELLOWORLD"
    STR2 DB 10 DUP(?)
.CODE
    MAIN PROC
        MOV AX,@DATA
        MOV DS, AX
        MOV ES, AX
        
        LEA SI, STR1
        LEA DI, STR2
        ADD DI, 9  
        CLD

        MOV CX, 10
    SWAP:
        MOVSB
        SUB DI, 2
        LOOP SWAP
        
        LEA SI, STR2
        CLD
        MOV AH, 2
        MOV CX, 10
    PRINT:
        LODSB
        MOV DL, AL
        INT 21H
        LOOP PRINT
        
        MOV AH, 4CH
        INT 21H
    MAIN ENDP
        END MAIN 
        