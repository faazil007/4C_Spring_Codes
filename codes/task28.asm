.model small
.stack 100h

.data
msg1 db 13,10," PRESS 1 FOR ADDITION",13,10
     db " PRESS 2 FOR SUBTRACTION",13,10
     db " PRESS 3 FOR MULTIPLICATION",13,10
     db " PRESS 4 FOR QUOTIENT",13,10
     db " PRESS 5 FOR REMAINDER",13,10
     db " PRESS 6 TO EXIT",13,10,'$'

msg2 db 13,10,"Enter first number: $"
msg3 db 13,10,"Enter second number: $"
msg4 db 13,10,"Result: $"
msg5 db 13,10,"Do you want to perform another calculation? (Y/N): $"
newline db 13,10,'$'

num1 dw ?
num2 dw ?
result dw ?

.code
main proc
    mov ax, @data
    mov ds, ax

start_menu:
    ; Display menu
    lea dx, msg1
    call print

    ; Get user choice
    call get_input
    sub al, '0'         ; ASCII to integer
    mov bl, al

    cmp bl, 6
    je exit

    ; Get first number
    lea dx, msg2
    call print
    call get_number
    mov num1, ax

    ; Get second number
    lea dx, msg3
    call print
    call get_number
    mov num2, ax

    ; Prepare for operation
    mov ax, num1
    mov bx, num2

    cmp bl, 1
    je addition
    cmp bl, 2
    je subtraction
    cmp bl, 3
    je multiplication
    cmp bl, 4
    je division
    cmp bl, 5
    je remainder

    jmp start_menu

addition:
    add ax, bx
    jmp show_result

subtraction:
    sub ax, bx
    jmp show_result

multiplication:
    mul bx       ; AX = AX * BX
    jmp show_result

division:
    xor dx, dx   ; clear DX before division
    cmp bx, 0
    je div_error
    div bx       ; AX / BX
    jmp show_result

remainder:
    xor dx, dx
    cmp bx, 0
    je div_error
    div bx
    mov ax, dx   ; Remainder in DX
    jmp show_result

div_error:
    lea dx, newline
    call print
    mov dx, offset msg4
    call print
    mov dx, offset newline
    call print
    jmp ask_again

show_result:
    mov result, ax
    lea dx, msg4
    call print
    mov ax, result
    call print_number
    lea dx, newline
    call print

ask_again:
    lea dx, msg5
    call print
    call get_input
    cmp al, 'Y'
    je start_menu
    cmp al, 'y'
    je start_menu

exit:
    mov ah, 4ch
    int 21h
main endp

; --------------------------------------------------

; ----------- Print String -------------
print proc
    mov ah, 09h
    int 21h
    ret
print endp

; ----------- Get Single Character Input -------------
get_input proc
    mov ah, 01h
    int 21h
    ret
get_input endp

; ----------- Get Integer Number Input -------------
get_number proc
    xor cx, cx        ; Clear CX = result
    xor bx, bx
read_digit:
    mov ah, 01h
    int 21h
    cmp al, 13
    je done_read
    sub al, '0'
    mov bl, al
    mov ax, cx
    mov dx, 10
    mul dx
    add ax, bx
    mov cx, ax
    jmp read_digit

done_read:
    mov ax, cx
    ret
get_number endp

; ----------- Print Integer Number in AX -------------
print_number proc
    cmp ax, 0
    jne convert
    mov dl, '0'
    mov ah, 02h
    int 21h
    ret

convert:
    mov cx, 0
    mov bx, 10

next_digit:
    xor dx, dx
    div bx
    push dx
    inc cx
    test ax, ax
    jnz next_digit

print_digits:
    pop dx
    add dl, '0'
    mov ah, 02h
    int 21h
    loop print_digits
    ret
print_number endp

end main
