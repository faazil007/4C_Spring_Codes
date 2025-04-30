TITLE Read Hex Digit and Show Decimal

.stack

.data
    HexDigit    DB ?                          ; To store the input character
    PromptMsg   DB "ENTER A HEX DIGIT: ", '$' ; Prompt message
    ResultMsg   DB 0Ah, 0Dh, "IN DECIMAL IT IS ", '$' ; Result message

.code
main proc
    MOV AX, @data     ; Initialize data segment
    MOV DS, AX

    ; --- Prompt the user ---
    MOV DX, offset PromptMsg
    MOV AH, 9
    INT 21h

    ; --- Read hex digit (A-F) ---
    MOV AH, 1
    INT 21h            ; Read char into AL
    MOV HexDigit, AL   ; Save it

    ; --- Convert ASCII 'A'–'F' to decimal (10–15) ---
    SUB AL, 'A'        ; 'A' becomes 0, 'B'=1,...'F'=5
    ADD AL, 10         ; Adjust to 10–15
    MOV BL, AL         ; Store result in BL

    ; --- Print "IN DECIMAL IT IS" ---
    MOV DX, offset ResultMsg
    MOV AH, 9
    INT 21h

    ; --- Convert BL (decimal 10–15) to characters for printing ---
    MOV AX, 0          ; Clear AX
    MOV AL, BL         ; Move sum to AL

    MOV CL, 10         ; Divisor
    DIV CL             ; AX / 10 ? AL=quotient, AH=remainder

    ; Print tens digit
    ADD AL, '0'
    MOV DL, AL
    MOV AH, 2
    INT 21h

    ; Print ones digit
    MOV AL, AH         ; Remainder in AH
    ADD AL, '0'
    MOV DL, AL
    MOV AH, 2
    INT 21h

    ; --- Exit to DOS ---
    MOV AH, 4Ch
    INT 21h
main endp

end main
