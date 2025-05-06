MOV     CX, 16        ; We need to check 16 bits
MOV     BX, 0         ; BX will count the number of 1s

parity_loop:
SHR     AX, 1         ; Shift right → LSB goes to Carry flag
JNC     skip_inc      ; If Carry is clear, skip increment
INC     BX            ; Else increment count of 1s

skip_inc:
LOOP    parity_loop   ; Repeat 16 times

; Now check parity (even = 1, odd = 0)
MOV     AX, BX        ; Move count into AX to check parity
AND     AL, 1         ; Mask the lowest bit (even/odd check)
JZ      even_parity   ; If zero, it's even parity

; ----- Odd Parity -----
; (Here you can set a custom "parity flag" or display a message)
; Example: setting PF = 0 using memory or variable
; (Note: Parity Flag itself can't be set directly)
JMP     done

even_parity:
; ----- Even Parity -----
; You can set your simulated Parity Flag = 1 here

done:
; Program ends or continues
