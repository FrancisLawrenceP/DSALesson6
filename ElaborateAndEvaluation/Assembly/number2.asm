section .data
    carList db "Lexus", 0, "Porsche", 0, "Lincoln", 0, "Toyota", 0, "Mercedes-Benz", 0, "Kia", 0, "BMW", 0, "Honda", 0, "Hyundai", 0, "Subaru", 0, "Audi", 0
    carListEnd db 0, '$'  ; DOS requires '$' at the end for string display

section .bss
    head resb 4

section .text
    global _start

_start:
    ; Initialize head to null
    mov dword [head], 0

    ; Append cars to the list
    mov edi, carList
    call append
    mov edi, carList + 6
    call append
    mov edi, carList + 14
    call append
    mov edi, carList + 22
    call append
    mov edi, carList + 29
    call append
    mov edi, carList + 43
    call append

    ; Prepend a car to the list
    mov edi, carList + 47
    call prepend

    ; Insert a car after "Porsche"
    mov edi, carList + 6
    mov edx, carList + 51
    call insertAfter

    ; Replace "Lincoln" with "Hyundai"
    mov edi, carList + 14
    mov edx, carList + 57
    call replace

    ; Replace the last car with "Subaru"
    mov edx, carList + 65
    call replaceLast

    ; Insert a car in the middle
    mov edx, carList + 71
    call insertMiddle

    ; Display the list of cars
    call display

    ; Exit
    mov ax, 4C00h
    int 21h

append:
    ; Find the end of the list
    mov esi, [head]
    test esi, esi
    jz .append_first
.append_loop:
    mov eax, [esi]
    test eax, eax
    jz .append_found
    mov esi, eax
    jmp .append_loop
.append_found:
    ; Append the new car
    mov [esi], edi
    mov [edi], 0
    ret
.append_first:
    ; First element in the list
    mov [head], edi
    mov [edi], 0
    ret

prepend:
    ; Prepend the new car
    mov eax, [head]
    mov [edi], eax
    mov [head], edi
    ret

insertAfter:
    ; Insert after a specific car
    mov esi, edi
    mov eax, [esi]
    mov [esi], edx
    mov [edx], eax
    ret

replace:
    ; Replace a specific car
    mov esi, edi
    mov [esi], edx
    ret

replaceLast:
    ; Replace the last car
    mov esi, [head]
    test esi, esi
    jz .replace_last_first
.replace_last_loop:
    mov eax, [esi]
    test eax, eax
    jz .replace_last_found
    mov esi, eax
    jmp .replace_last_loop
.replace_last_found:
    mov [esi], edx
    ret
.replace_last_first:
    ; If the list is empty, just set the head
    mov [head], edx
    ret

insertMiddle:
    ; Insert in the middle of the list
    mov esi, [head]
    test esi, esi
    jz .insert_middle_first
    mov ecx, 0
.insert_middle_count:
    mov eax, [esi]
    test eax, eax
    jz .insert_middle_found
    inc ecx
    mov esi, eax
    jmp .insert_middle_count
.insert_middle_found:
    shr ecx, 1
    mov esi, [head]
.insert_middle_loop:
    test ecx, ecx
    jz .insert_middle_insert
    mov esi, [esi]
    dec ecx
    jmp .insert_middle_loop
.insert_middle_insert:
    mov eax, [esi]
    mov [esi], edx
    mov [edx], eax
    ret
.insert_middle_first:
    ; If the list is empty, just set the head
    mov [head], edx
    ret

display:
    ; Display the list of cars
    mov esi, [head]
    test esi, esi
    jz .display_done
.display_loop:
    mov eax, esi
    call print_string
    mov esi, [esi]
    test esi, esi
    jnz .display_loop
.display_done:
    ret

print_string:
    ; Print a null-terminated string
    mov ah, 09h            ; DOS print string function
    mov dx, eax            ; DS:DX points to the string
    int 21h
    ret
