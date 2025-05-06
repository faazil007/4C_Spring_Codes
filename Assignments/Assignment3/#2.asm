AND     AX, 0001h     ; Isolate lowest bit of AX
SHL     AX, 15        ; Shift it to highest bit position
OR      BX, AX        ; Set the highest bit of BX with AX's bit 0
