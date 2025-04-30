.model small
.stack 100h

.data
array1  DW  1000h, 2000h, 3000h, 4000h  ; 4 elements, 16-bit each
array2  DW  0, 0, 0, 0, 0, 0, 0, 0      ; 8 WORDs = 4 DWORDs (2 WORDs per doubleword)
count   DW  4                           ; Number of 16-bit elements

.code
start:
    MOV     AX, @data
    MOV     DS, AX
    MOV     ES, AX                     ; Use same segment for ES

    LEA     SI, array1                 ; Source pointer
    LEA     DI, array2                 ; Destination pointer

    MOV     CX, count                 ; Loop counter

copy_loop:
    MOV     AX, [SI]                  ; Load 16-bit word from array1
    MOV     [DI], AX                  ; Store it to low-word of 32-bit space
    MOV     WORD PTR [DI+2], 0000h    ; High-word = 0 (we're extending to 32-bit)
    ADD     SI, 2                     ; Move to next word in source
    ADD     DI, 4                     ; Move to next doubleword space (4 bytes)
    LOOP    copy_loop

    ; Exit program
    MOV     AH, 4Ch
    INT     21h

end start
