.data 
    myBytes     DB 10h, 20h, 30h, 40h
    myWords     DW 8Ah, 3Bh, 72h, 44h, 66h
    myDoubles   DD 1, 2, 3, 4, 5
    myPointer   DW myWords

.code
START:
    ; Load value from myBytes[0]
    mov si, OFFSET myBytes
    mov al, [si]        

    ; Load value from myBytes[3]
    mov al, [si+3]      

    ; Load word from myWords[1] (2nd word, offset = 2)
    mov si, OFFSET myWords + 2
    mov ax, [si]        

    ; Load 16-bit part of 3rd double word (assuming low word)
    mov di, 8                   ; 8 = 2 * 4th index (0-based) in DD
    mov dx, WORD PTR [myDoubles + di]  ; get lower word of that dword

    ; Removed invalid EDI usage

    ; myPointer contains address of myWords
    mov bx, myPointer          ; bx = offset of myWords
    mov ax, [bx+4]             ; access 3rd word in myWords (offset 4)

    ; Alternatively using si
    mov si, myPointer
    mov ax, [si+2]             ; aligned access (word at index 1)

    ; Access previous word (be careful: si must be > 3 for this to be valid)
    mov ax, [si-2]             ; move back by 1 word

    END START
