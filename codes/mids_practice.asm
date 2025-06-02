TITLE 
;It's My First Practice Program for MIDs


.STACK 100h

.DATA
    ; Global Variable Declarations
    MYBYTE   DB ?
    MYBYTES  DB 5, 1011b, 0ABh , 'A' , "Zahid"
    MESSAGE  DB 0AH,0DH, " Assalam-o-Alaikum , Enter a Character :: $"
    MESSAGE2 DB 0AH,0DH, " You've Entered a Character :: $"
    MYWORD   DW 0ABCDH
    MYDOUBLE DD 12345678H
    X        DW 100

.CODE
MAIN PROC
    MOV AX, @DATA
    MOV DS, AX

    ; Show first message
    MOV DX, OFFSET MESSAGE
    MOV AH, 9
    INT 21H

    ; Take character input
    MOV AH, 1
    INT 21H
    MOV MYBYTE, AL

    ; Show second message
    MOV DX, OFFSET MESSAGE2
    MOV AH, 9
    INT 21H

    ; Show entered character
    MOV AL, MYBYTE
    MOV DL, AL
    MOV AH, 2
    INT 21H

    ; Exit program
    MOV AH, 4CH
    INT 21H
MAIN ENDP

END MAIN
TITLE
; Read two digits and show their sum

.STACK
;-----------------------------------




;-----------------------------------

.DATA
;-----------------------------------
    FIRSTDIGIT  DB ?
    SECONDDIGIT DB ?
    SUM         DB ?
    
    MSGQ        DB "ENTER THE FIRST DIGIT :: " , '$'
    MSGQ2       DB "ENTER THE SECOND DIGIT :: ",'$'
    MSGRESULT   DB 0AH,0DH,"THE SUM OF ",'$'
    MSGAND      DB "AND ", '$'
    MSGIS       DB "IS" , '$'
    
    
;-----------------------------------


    MAIN PROC
        MOV AX,@DATA
        MOV DS,AX
        
        MOV DX, OFFSET MSGQ
        MOV AH,9
        INT 21H
        
        MOV AH,1
        INT 21H
        MOV FIRSTDIGIT, AL
        SUB AL,'0'
        MOV BL,AL
        
        
        MOV DX, OFFSET MSGQ2
        MOV AH,9
        INT 21H
        
        MOV AH,1
        INT 21H
        MOV SECONDDIGIT,AL
        SUB AL, '0'
        ADD BL,AL
        MOV SUM,BL
        
        MOV DX, OFFSET MSGRESULT
        MOV AH,9
        INT 21H
        
        MOV AL,FIRSTDIGIT
        MOV DL,AL
        MOV AH,2
        INT 21H
        
        MOV DX, OFFSET MSGAND
        MOV AH,9
        INT 21H
        
        MOV AL,SECONDDIGIT
        MOV DL,AL
        MOV AH,2
        INT 21H
        
        MOV DX, OFFSET MSGIS
        MOV AH,9
        INT 21H
        
        MOV AL,SUM
        ADD AL,'0'
        MOV DL,AL
        MOV AH,2
        INT 21H
        
        MOV AH,4CH
     
     MAIN ENDP
    END MAIN
             