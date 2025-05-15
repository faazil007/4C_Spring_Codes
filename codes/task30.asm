.MODEL SMALL
.STACK 100h

.DATA
; No data needed for this code

.CODE
MAIN PROC
    CALL INPUTDEC       ; Call the procedure to get integer input
    CALL OUTPUTDEC
    MOV AH, 4CH      ; Exit to DOS
    INT 21H
MAIN ENDP

;-----------------------------------------
INPUTDEC PROC
    MOV BX, 0        ; BX will store the final numeric result
    MOV CX, 10       ; Multiplier for place value (not needed for one-digit input here)

    MOV AH, 1        ; DOS function to read character from keyboard
    INT 21H          ; Input in AL

    CMP AL, '0'      ; Check if input is >= '0'
    JB INVALID_INPUT

    CMP AL, '9'      ; Check if input is <= '9'
    JA INVALID_INPUT

    SUB AL, '0'      ; Convert ASCII digit to integer (e.g., '5' -> 5)
    MOV AH, 0        ; Clear AH to form a full 16-bit value
    MOV AX, AX       ; AX now has the integer value
    MOV BX, AX       ; Store it in BX

    JMP RETURN_RESULT
    
    
                     
                                       

INVALID_INPUT:
    MOV BX, 0        ; Set result to 0 if invalid input

RETURN_RESULT:
    MOV AX, BX       ; Return result in AX
    RET
INPUTDEC ENDP




OUTPUTDEC PROC                    ; This procedure displays the value stored in AX register as a decimal integer
    MOV BX,10        ; To be used as divisor
    MOV CX,0         ; To be used as digit counter
                     
                     ; Separate each of the digits in the integer value 
OUTPUTDEC1:
    MOV DX,0         ; Higher part is zero, max input value is of higher bytes                 
    DIV BX           ; (DX:AX)/BX Quotient in AX and Remainder in DX
                     
    PUSH DX          ; Push the remainder on to the stack
                     ; The separated
                     
    INC CX           ; Increase the digit count             ;Repeat the above procedure until all digits are separated
    CMP AX,0         ; Check whether the quotient is zero
    JNZ OUTPUTDEC1
    
OUTPUTDEC2:
    POP DX
    ADD DL,'0'
    MOV AH,2
    INT 21H
    
    LOOP OUTPUTDEC2
    RET
    OUTPUTDEC ENDP                         

;-----------------------------------------
END MAIN
