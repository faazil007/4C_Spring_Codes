SHR     AL, 1        ; Shift AL right by 1 bit → LSB goes to CF
JNC     skip_set     ; If CF = 0, skip setting MSB
OR      AL, 80h      ; Set MSB (bit 7) to 1

skip_set:
; AL is now rotated right by 1 bit
