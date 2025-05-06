.model small
.stack 100h

.data
val1    DW  10
val2    DW  5
val3    DW  2

.code
start:
    MOV     AX, @data
    MOV     DS, AX

    MOV     AX, val2     ; AX = val2
    NEG     AX           ; AX = -val2

    SUB     AX, val3     ; AX = AX - val3 => -val2 - val3
    ADD     AX, val1     ; AX = AX + val1 => -val2 - val3 + val1
    ADD     AX, 7        ; AX = AX + 7    => final result

    ; --- Convert number in AX to ASCII and print ---
    ; We'll assume the result is between 0 and 9999
    MOV     BX, 10       ; Divisor
    MOV     CX, 0        ; Counter for digits
                                                                                      
store_digits:
    XOR     DX, DX
    DIV     BX           ; AX / 10, quotient in AX, remainder in DX
    PUSH    DX           ; Save remainder (digit)
    INC     CX           ; Count digit
    CMP     AX, 0
    JNE     store_digits

print_digits:
    POP     DX
    ADD     DL, 30h      ; Convert to ASCII
    MOV     AH, 2
    INT     21h
    LOOP    print_digits

    ; --- Exit program ---
    MOV     AH, 4Ch
    INT     21h

end start
