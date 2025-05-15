.model small
.stack 100h

.data
msg1 db "BEFORE POPF: FLAGS restored",13,10,'$'
msg2 db "AFTER CHANGING FLAGS: PUSHF saved original",13,10,'$'

.code
main:
    mov ax, @data
    mov ds, ax

    ; Do some operation to set flags
    mov ax, 0
    dec ax        ; This will set Sign flag (SF) and Zero flag cleared
    pushf         ; Save current flags on stack

    ; Simulate change in flags
    clc           ; Clear carry flag
    stc           ; Set carry flag (CF = 1)
    cli           ; Disable interrupts (IF = 0)

    lea dx, msg2
    call print

    popf          ; Restore previous flags from stack
    lea dx, msg1
    call print

    mov ah, 4ch
    int 21h

; ---------- Print String Procedure ------------
print proc
    mov ah, 09h
    int 21h
    ret
print endp

end main
