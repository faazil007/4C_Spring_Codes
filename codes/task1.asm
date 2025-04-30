Title 
; Its my 1st Program
; Program Description 
; Interactive program to input a character and display the character

 ; '$' end of the Function for String

.Stack                         ; To definr/Associate default stack of size 1KB with our program

.data                          ; To define Data Segment


; <Global variable declare>  

MyByte   DB ?

MyBytes  DB 5, 10110b, 0ABh, 'A', "Zahid"

Message  DB "Assalam-o-Alaikum, Enter a charachter : ", '$'    

Message2 DB 0Ah, 0Dh, "You entered a character : ", '$'

Myword   DW 0ABCDh

Mydouble DD 12345678h

X DW 100


.code                          ; To define Code Segment
    main proc                  ; start of the procedure
        
        MOV AX, @data          ; Initialize the Data Segment explicity, 
        
        MOV DS, AX             ; DS is Data segment register, AX is Accumulator 
        
        ;----------------------------------------- 
        
                                                                             
        
        MOV DX, offset Message ; place the offset address and string in DX
        
        MOV AH, 9              ; of service to display the String
        
        Int 21h                ; service activation are call 
        
        
        
        MOV AH, 1              ; Input a character from keyboard and places its Ascii values in AL Registers
        
        Int 21h                ; Output the entered character
        
        MOV Mybyte, AL         ; Save or store the character in memory or variable    
        
        
        
        
        
        MOV DX, offset Message2; place the offset address and string in DX
        
        MOV AH, 9              ; of service to display the String
        
        Int 21h                ; service activation are call
        
        
        
        
        MOV DL, Mybyte
        
        MOV AH, 2
        
        Int 21h               
        
        
        
        ;XCHG AL,BX  ; Size MIS-MATCH
        
        ;XCHG X,Y    ; Both operands can't be memory references
        
        ;XCHG IP,BP  ; IP register can't be the destination operand and can't be exchanged
        
        ;XCHG DS,CS  ; Segment registers can't be exchanged
                    
        ;XCHG DS, AX ; Same like Previous one  
        
        
       ; MOV BX,1234h
       ; MOV SI,5678h
        
       ; XCHG BX, SI  ; Valid
       
       ; XCHG DI , X  ; Valid if and only if the x is defined
       
        ;XCHG CX,400  ; Constant can't be a operand
        
        
        ;-----------------------------------------
        
        MOV AH, 4ch            ; Return control back to OS
        
        Int 21h
    
    main endp

end main                       ; End of the program indicator + specify the 1st instruction from where the Program Start




