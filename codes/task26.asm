TITLE: ASSIGNMENT 03
  
;-------------------------------------
;THEORY PART  

; QUESTION NO 03 
STC
MOV AL, 11010101B
RCL AL, 1 

MOV AH, 4CH
INT 21H

;QUESTION NO 04
SHR AX, 1

;QUESTION NO 05
mov al,0D4h
shr al,1 ;AL= 

mov al,0D4h
sar al,1 ;AL=

mov al,0D4h
sar al,4 ;AL=

mov al,0D4h
rol al,1 ;AL=

mov al,0D4h
ror al,3 ;AL=

mov al,0D4h
rol al,7 ;AL=

stc
mov al,0D4h
rcl al,1 ;AL=

clc
mov al,0D4h
rcr al,3 ;AL= 

;QUESTION NO 06
SHL AX, 4

;QUESTION NO 07
SHR BX, 2

;QUESTION NO 08
ROL DL, 4


;------------------------------------
; PRACTICAL PART  
; QUESTION NO 01
;EXAMPLE 01
.MODEL  SMALL
.STACK  100H
.DATA
    MSG1    DB  "PLEASE ENTER CHARACTER: $"  
    MSG2    DB  10,13,"THE NUMBER OF 1 ARE: $"
    MSG3    DB  10,13,"THE NUMBER OF 0 ARE: $"
    CONT    DB  0
.CODE
    MAIN    PROC
 
        MOV AX, @DATA
        MOV DS, AX
        
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
            
            MOV AH, 4CH
            INT 21H
            
            MAIN    ENDP
    END MAIN
    
;EXAMPLE 02 
.MODEL SMALL
.STACK 100H
.CODE
    MAIN PROC
        XOR BX, BX
        MOV AH, 1
        
    INPUT:
        INT 21H
        CMP AL, 13
        JE END_INPUT

        SHL BX, 1
        SUB AL, 48
        OR BL, AL
        JMP INPUT

        
END_INPUT:        
        MOV AH, 4CH
        INT 21H
        
    MAIN  ENDP
   END   MAIN

; EXAMPLE 03
.MODEL SMALL
.STACK 100H
.CODE
    MAIN PROC
        MOV BX, 5
        MOV CX, 16
        MOV AH, 2 
        
    PRINT:
        ROL BX, 1
        JC DISPONE
        
        MOV DL, '0'
        INT 21H
        
        LOOP PRINT
        JMP EXIT
        
    DISPONE:
        MOV DL, '1'
        INT 21H
        
        LOOP PRINT
    EXIT:        
        MOV AH, 4CH
        INT 21H
        
    MAIN  ENDP
   END   MAIN

; EXAMPLE 04
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

; EXAMPLE 05
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

;EXAMPLE 06
.MODEL  SMALL
.STACK  100H   
.DATA
    MSG DB  10,13,"IN BINARY IT IS: $" 
.CODE   
    MAIN    PROC  
        MOV AX, @DATA
        MOV DS, AX
        
        XOR BX, BX
        MOV CL, 4
        MOV AH, 1
        
      INPUT:
        INT 21H
        CMP AL, 13
        JE  END_INPUT
        
        SHL BX, CL
        CMP AL, '9'
        JLE NUMBER
        SUB AL, 55
        JMP INSERT
        
      NUMBER:
        SUB  AL, 48
       
      INSERT:
        OR  BL, AL
        JMP INPUT
        
      END_INPUT:

        MOV AH, 9
        LEA DX, MSG
        INT 21H

        MOV CX, 16
        
     PRINT:
        ROL BX, 1
        JC  DISPONE
        MOV DL, '0' 
        MOV AH, 2
        INT 21H
LOOP PRINT
        JMP EXIT
        
      DISPONE:
        MOV DL, '1' 
        MOV AH, 2
        INT 21H
        LOOP PRINT

      EXIT:  
        	MOV	AH,	4CH
	INT	21H
MAIN    ENDP
    END MAIN
    
;EXAMPLE 07
.MODEL  SMALL
.STACK  100H   
.DATA
    MSG DB  10,13,"IN HEX IT IS: $" 
.CODE   
    MAIN    PROC  
        MOV AX, @DATA
        MOV DS, AX
        
        XOR   BX, BX
        MOV   AH, 1
          
      INPUT:
        INT 21H
        CMP AL, 13
        JE  END_INPUT
        SHL BX, 1
        SUB AL, 48
        OR  BL, AL
        JMP INPUT

END_INPUT:  

        MOV AH, 9
        LEA DX, MSG
        INT 21H
       
        MOV CX, 4
        MOV AH, 2
        
     PRINT:
         MOV    DL, BH
         SHR    DL, 1
         SHR    DL, 1
         SHR    DL, 1
         SHR    DL, 1
         
         CMP    DL, 9  
         JLE    NUMBER
         ADD    DL, 55
         JMP    DISPLAY
         
     NUMBER:
        ADD DL, 48
        
    DISPLAY:
        INT 21H  
        ROL BX, 1
        ROL BX, 1
        ROL BX, 1
        ROL BX, 1
        LOOP PRINT
             
        MAIN    ENDP
    END MAIN
    
;EXAMPLE 08
.MODEL  SMALL
.STACK  100H    
.DATA
    MSG DB  10,13,"YOU HAVE TYPED:  $"
.CODE
    MAIN    PROC  
        MOV AX, @DATA
        MOV DS, AX
        XOR BX, BX
        MOV CL, 4
        MOV AH, 1
        
      INPUT:
        INT 21H
        CMP AL, 13
        JE  END_INPUT
        
        SHL BX, CL
        CMP AL, '9'
        JLE NUMBER
        SUB AL, 55
        JMP INSERT
        
      NUMBER:
        SUB  AL, 48
       
      INSERT:
        OR  BL, AL
        JMP INPUT
        
      END_INPUT:  
        MOV AH, 9
        LEA DX, MSG
        INT 21H
      
        MOV  CX,  4

        MOV  AH,  2 
      
      PRINT:
        MOV DL, BH
        SHR DL, 1
        SHR DL, 1
        SHR DL, 1
        SHR DL, 1
CMP DL, 9
        JLE  DISPNUMBER
        ADD DL, 55
        JMP DISP
        
       DISPNUMBER:
        ADD DL, 48
        
       DISP:
        INT 21H
        ROL BX, 1
        ROL BX, 1
        ROL BX, 1
        ROL BX, 1
        
        LOOP PRINT
      
        MOV AH, 4CH
        INT 21H
        
        MAIN    ENDP
    END MAIN 

;EXAMPLE 09
.MODEL  SMALL
.STACK 100H  
.DATA
    MSG DB  10,13,"YOU HAVE ENTERED $: "
.CODE
    MAIN    PROC    
          MOV   AX, @DATA
          MOV   DS, AX
          XOR   BX, BX
          MOV   AH, 1
          
      INPUT:
        INT 21H
        CMP AL, 13
        JE  END_INPUT

        SHL BX, 1
        SUB AL, 48
        OR  BL, AL
        JMP INPUT

END_INPUT:  

        MOV CX, 16 
        
        MOV  AH,    9
        LEA DX, MSG
        INT 21H        
                
      PRINT:
        ROL BX, 1
        JC  DISPONE
        MOV DL, '0' 
        MOV AH, 2
        INT 21H
        
        LOOP PRINT
        JMP EXIT        
      DISPONE:
        MOV DL, '1' 
        MOV AH, 2
        INT 21H
        LOOP PRINT
        
      EXIT:
        MOV AH, 4CH
        INT 21H
        
        MAIN    ENDP
    END MAIN 


; QUESTION NO 02
SHL AX, 1
RCL BX, 1 

; QUESTION NO 03 
SHR AL, 1       
JNC SKIP_SET_MSB
OR AL, 80h   
SKIP_SET_MSB:

; QUESTION NO 04 
MOV CX, 16       
MOV BX, AX       
MOV DL, 0    
CHECK_BIT:
SHR BX, 1     
JNC SKIP_INC
INC DL        
SKIP_INC:
LOOP CHECK_BIT
AND DL, 1
JZ SET_PARITY    
CLC              
JMP DONE
SET_PARITY:
STC              
DONE:

; QUESTION NO 05 
MOV AX, 123   
MOV BX, AX      
SHL BX, 2     
SHL AX, 5       
ADD AX, BX      

; QUESTION NO 06
MOV BX, y    
DEC BX           
AND AX, BX 

; QUESTION NO 07
MOV BX, AX      
SAR BX, 15      
ADD AX, BX       
XOR AX, BX