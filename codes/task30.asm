.MODEL SMALL
.STACK 100h

.DATA
; Koi static data nahi

.CODE

InDec PROC
    ; 1_Initialization
    MOV BX, 0       ; For Intermediate Result
    MOV CX, 10      ; For Multiplier for Decimal Number
    
InDec1:   
    ; 2_Input Char
    MOV AH, 1       ; Input char will be in AL
    INT 21h
    
    ; 3_Verify Whether it is Digit Char or Not
    CMP AL, '0'
    JB InDec2
    CMP AL, '9'
    JA InDec2
    
    ; 4_Convert Digit char into Digit
    SUB AL, '0'     ; Or SUB AL, 30h or 48
    
    ; Multiply IR with Multiplier
    MOV AH, 0       ; Make AH zero before starting
    PUSH AX         ; Save digit in stack
    
    MOV AX, BX      ; Multiplicand (IR/BX) into AX
    MUL CX          ; DX:AX = AX * CX
    
    ; 6_ Add the Digit into new IR
    POP BX          ; Place the digit in BX from stack
    ADD BX, AX      ; BX = BX + AX
    
    ; 7_Goto
    JMP InDec1
    
InDec2:
    MOV AX, BX      ; Return the converted value in AX
    RET
InDec ENDP

Outdec PROC
    ; Display the value stored in AX as a decimal integer
    
    MOV BX, 10      ; Divisor
    MOV CX, 0       ; Digit counter
    
Outdec1:
    MOV DX, 0       ; Higher part zero for DIV
    DIV BX          ; Divide AX by BX, quotient in AX, remainder in DX
    
    PUSH DX         ; Push remainder (digit) on stack
    INC CX          ; Increase digit count
    
    CMP AX, 0       ; Check if quotient zero
    JNZ Outdec1     ; If not zero repeat
    
Outdec2:
    POP DX          ; Pop digit from stack
    ADD DL, '0'     ; Convert to ASCII
    
    MOV AH, 2       ; DOS function to print char
    INT 21h
    
    LOOP Outdec2    ; Loop CX times
    
    RET
Outdec ENDP

Main PROC
    MOV AX, 64937
    CALL Outdec
    MOV AH, 4Ch     ; Terminate program
    INT 21h
Main ENDP

END Main
