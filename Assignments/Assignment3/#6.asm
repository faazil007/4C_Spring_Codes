MOV     EAX, n         ; Load n (32-bit)
MOV     EBX, y         ; Load y (must be power of 2)

SUB     EBX, 1         ; y = y - 1
AND     EAX, EBX       ; x = n AND (y - 1)
                      ; Result in EAX
