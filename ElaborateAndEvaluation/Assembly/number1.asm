section .data
    msg1 db "Term 35 is: ", 0
    msg2 db "Term 125 is: ", 0
    msg3 db "Term 100 is: ", 0
    msg4 db "Term 36 is: ", 0
    newline db 10, 0

section .bss
    result resd 1

section .text
    global _start

_start:
    ; part a
    mov eax, 3          ; firstTermA
    mov ebx, 6          ; commonDifferenceA
    mov ecx, 35         ; n
    call findNthTerm
    mov [result], eax
    mov eax, 4
    mov ebx, 1
    mov ecx, msg1
    mov edx, 12
    int 0x80
    call print_result

    ; part b
    mov eax, 4          ; firstTermB
    mov ebx, -5         ; commonDifferenceB
    mov ecx, 125        ; n
    call findNthTerm
    mov [result], eax
    mov eax, 4
    mov ebx, 1
    mov ecx, msg2
    mov edx, 13
    int 0x80
    call print_result

    ; part c
    mov eax, -8         ; term5C
    mov ebx, 72         ; term25C
    mov ecx, 5          ; n1
    mov edx, 25         ; n2
    sub ebx, eax        ; term25C - term5C
    sub edx, ecx        ; n2 - n1
    cdq
    idiv edx            ; commonDifferenceC = (term25C - term5C) / (n2 - n1)
    mov ebx, eax        ; commonDifferenceC
    mov eax, -8         ; term5C
    sub ecx, 1          ; n1 - 1
    imul ecx, ebx       ; (n1 - 1) * commonDifferenceC
    sub eax, ecx        ; firstTermC = term5C - (n1 - 1) * commonDifferenceC
    mov ecx, 100        ; n
    call findNthTerm
    mov [result], eax
    mov eax, 4
    mov ebx, 1
    mov ecx, msg3
    mov edx, 13
    int 0x80
    call print_result

    ; part d
    mov eax, -32        ; term5D
    mov ebx, 85         ; term18D
    mov ecx, 5          ; n1
    mov edx, 18         ; n2
    sub ebx, eax        ; term18D - term5D
    sub edx, ecx        ; n2 - n1
    cdq
    idiv edx            ; commonDifferenceD = (term18D - term5D) / (n2 - n1)
    mov ebx, eax        ; commonDifferenceD
    mov eax, -32        ; term5D
    sub ecx, 1          ; n1 - 1
    imul ecx, ebx       ; (n1 - 1) * commonDifferenceD
    sub eax, ecx        ; firstTermD = term5D - (n1 - 1) * commonDifferenceD
    mov ecx, 36         ; n
    call findNthTerm
    mov [result], eax
    mov eax, 4
    mov ebx, 1
    mov ecx, msg4
    mov edx, 12
    int 0x80
    call print_result

    ; exit
    mov eax, 1
    xor ebx, ebx
    int 0x80

findNthTerm:
    push ebp
    mov ebp, esp
    mov eax, [ebp+8]    ; firstTerm
    mov ebx, [ebp+12]   ; difference
    mov ecx, [ebp+16]   ; n
    sub ecx, 1
    imul ecx, ebx
    add eax, ecx
    pop ebp
    ret

print_result:
    mov eax, [result]
    add eax, '0'
    mov [result], eax
    mov eax, 4
    mov ebx, 1
    mov ecx, result
    mov edx, 1
    int 0x80
    mov eax, 4
    mov ebx, 1
    mov ecx, newline
    mov edx, 1
    int 0x80
    ret