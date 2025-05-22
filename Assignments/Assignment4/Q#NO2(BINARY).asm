                      .MODEL SMALL
.STACK 100H
;-------------------------------------------------------------------------
.DATA
    MENU DB 0DH,0AH,  " BINARY CALCULATOR ",
         DB 0DH,0AH,  " -------MENU--------- ",
         DB 0DH,0AH,   "PRESS 1 FOR ADDITION           ::",
         DB 0DH,0AH,   "PRESS 2 FOR SUBTRACTION        ::",
         DB 0DH,0AH,   "PRESS 3 FOR MULTIPLICATION     ::",
         DB 0DH,0AH,   "PRESS 4 FOR DIVISION(REMAINDER)::",
         DB 0DH,0AH,   "PRESS 5 FOR DIVISION(QUOTIENT) ::",
         DB 0DH,0AH,   "PRESS 6 TO EXIT$ " 
         
         
     
     MSG1 DB 10,13, "ENTER FIRST BINARY ::,$"
     MSG2 DB 10,13, "ENTER SECOND BINARY::,$"
     MSG3 DB 10,13, "ERROR! ENTER A VALID BINARY VALUE::,$"
     MSG4 DB 10,13, "RESULT OF CALCULATION::,$"
     MSG5 DB 10,13, "PRESS ANY KEY TO PROCEED!!!,$"
     NEWLINE DB 0Dh, 0Ah, '$'
     PLUS_OPERATOR      DB "+$"
     MINUS_OPERATOR     DB "-$"
     MULTIPLY_OPERATOR  DB "*$"
     REMAINDER_OPERATOR DB "%$"
     QUOTIENT_OPERATOR  DB "/$"
     EQUALS_OPERATOR    DB "=$"
     TEMPORARY DB ?
     OPERAND1 DW ?
     OPERAND2 DW ?
;--------------------------------------------------------------------------
.CODE
    MAIN PROC
        MOV AX,@DATA
        MOV DS,AX
        
        
        
        START:
            MOV DX, OFFSET MENU
            CALL STRING_DISPLAY
            
            MOV DX, OFFSET NEWLINE
            CALL STRING_DISPLAY
            
            START2:
                CALL CHARACTER_INPUT
                MOV BL,TEMPORARY
            
                CMP BL,'1'
                JE ADDITION
            
                CMP BL,'2'
                JE SUBTRACTION
            
                CMP BL,'3'
                JE MULTIPLICATION
            
                CMP BL,'4'
                JE CHECKING_REMAINDER
            
                CMP BL,'5'
                JE CHECKING_QUOTIENT
            
                CMP BL,'6'
                JE QUIT
            
                JNE ERROR
           ;----------------------------------------------------------------- 
            ADDITION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND2, AX 
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                                
                MOV AX,OPERAND1
                CALL BINARY_OUTPUT
                MOV DX, OFFSET PLUS_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL BINARY_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV BX, OPERAND1
                ADD BX,OPERAND2
                
                MOV AX,BX
                CALL BINARY_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP START
          ;--------------------------------------------------------------------      
            SUBTRACTION:
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND2, AX                
                
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL BINARY_OUTPUT
                MOV DX, OFFSET MINUS_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL BINARY_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV BX, OPERAND1
                SUB BX,OPERAND2
                
                MOV AX,BX
                CALL BINARY_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP START
         ;-----------------------------------------------------------------------
            MULTIPLICATION:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND2, AX                
             
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL BINARY_OUTPUT
                MOV DX, OFFSET MULTIPLY_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL BINARY_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV AX, OPERAND1
                MUL OPERAND2
                CALL BINARY_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP START
         ;-------------------------------------------------------------------   
            CHECKING_REMAINDER:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND2, AX                
                    
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL BINARY_OUTPUT
                MOV DX, OFFSET REMAINDER_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL BINARY_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY
                
                MOV AX, 0
                MOV DX, 0
                MOV AX, OPERAND1
                DIV OPERAND2
                MOV AX, 0
                MOV AX, DX 
                
                CALL BINARY_OUTPUT
                
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP START
          ;-------------------------------------------------------------------      
             CHECKING_QUOTIENT:
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV DX, OFFSET MSG1
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND1, AX
            
                MOV DX, OFFSET MSG2
                CALL STRING_DISPLAY
                CALL BINARY_INPUT
                MOV OPERAND2, AX                
                    
                MOV DX, OFFSET NEWLINE
                CALL STRING_DISPLAY
                
                MOV AX,OPERAND1
                CALL BINARY_OUTPUT
                MOV DX, OFFSET QUOTIENT_OPERATOR
                CALL STRING_DISPLAY 
                
                MOV AX,OPERAND2
                CALL BINARY_OUTPUT
                MOV DX, OFFSET EQUALS_OPERATOR
                CALL STRING_DISPLAY   
                
            
                MOV AX, 0
                MOV DX, 0
                MOV AX, OPERAND1
                DIV OPERAND2
                    
                CALL BINARY_OUTPUT
                    
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP START
                
          ;--------------------------------------------------------------------
             ERROR:
                MOV DX, OFFSET MSG3
                CALL STRING_DISPLAY
                MOV DX, OFFSET MSG5
                CALL STRING_DISPLAY
                CALL CHARACTER_INPUT
                JMP START2
                
             JMP QUIT                
             
             QUIT:
                MOV AH,4CH
                INT 21H    
                   
    MAIN ENDP

;--------------------------------    
; 1st Proc    
;--------------------------------    
    CHARACTER_INPUT PROC
        MOV AH,1
        INT 21H
        MOV TEMPORARY,AL
        
        RET
      
    CHARACTER_INPUT ENDP
;--------------------------------    

;--------------------------------
; 2nd Proc
;--------------------------------    
    CHARACTER_OUTPUT PROC
        MOV AH,2
        INT 21H
        
        RET
        
    CHARACTER_OUTPUT ENDP    

;--------------------------------
; 3rd Proc
;--------------------------------
    STRING_DISPLAY PROC
        MOV AH,9
        INT 21H
        
        RET
    STRING_DISPLAY ENDP
       
;--------------------------------
; 4th Proc
;--------------------------------
    BINARY_INPUT PROC
        MOV BX,0
        MOV CX,2
        
        INPUT_BIN1:
            CALL CHARACTER_INPUT
            MOV AL,TEMPORARY
            
            CMP AL,'0'
            JB INPUT_BIN2
            
            CMP AL,'1'
            JA INPUT_BIN2
            
            SUB AL,'0'
            MOV AH,0
            PUSH AX
            MOV AX,BX
            MUL CX
            POP BX
            ADD BX,AX
            JMP INPUT_BIN1
            
        
        
        INPUT_BIN2:
            MOV AX,BX
            
        
        RET
        
    BINARY_INPUT ENDP            
    
;--------------------------------
; 5th Proc
;--------------------------------
    BINARY_OUTPUT PROC
        MOV BX,2
        MOV CX,0   
        
        OUTPUT_BIN1:
            MOV DX,0
            DIV BX
            PUSH DX
            INC CX
            CMP AX,0
            JNZ OUTPUT_BIN1
        
            
        DISPLAY_DIGITS:
            POP DX
            ADD DX,'0'
            CALL CHARACTER_OUTPUT
            LOOP DISPLAY_DIGITS
        
        RET
        
     BINARY_OUTPUT ENDP
    
;------------------------------------------------------------------------    
            
        
        