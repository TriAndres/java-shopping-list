# Постановка задачи
### Василий Иванович не доверяет курьерам и любит ходить по магазинам сам. Но 
### есть одна проблема: иногда он забывает купить что-то важное. Например, выйдя 
### за овощами для томатного супа, он может вернуться с полным пакетом 
### продуктов, в котором есть всё, кроме томатов.
### Напишите приложение, которое поможет Василию Ивановичу и другим 
### пользователям делать покупки по списку и ничего не забывать.
### Итак, вам нужно написать программу с консольным интерфейсом, которая будет 
### представлять собой цифровой список покупок. Программа должна уметь 
### выполнять четыре действия:
### * добавить товар в список,
### * показать список,
### * очистить список,
### * завершить работу.
### После выполнения любого из первых трёх действий программа должна снова 
### предложить список доступных действий. При выборе пункта «завершить работу», 
### ей нужно остановиться.
### Для простоты добавим ограничение на количество товаров: в список можно 
### добавлять не более восьми наименований. Поэтому если пользователю нужно 
### купить больше товаров, ему придётся предварительно выбрать восемь наиболее 
### важных из них.
# Задания повышенной сложности
### 1 Предположим, что особо забывчивый пользователь забыл, что уже внёс 
###   товар в список покупок, и пытается добавить его туда ещё раз. Доработайте 
###   программу так, чтобы в этом случае программа не добавляла дубликат, а 
###   выводила сообщение о том, что такой товар уже есть в списке.
### 2 Список ограниченного размера — это, конечно, неудобно. Особенно если 
###   нужно закупить продукты на неделю вперёд. Попробуйте убрать это 
###   ограничение. Доработайте программу так, чтобы при попытке добавить в 
###   массив элемент, выходящий за его пределы, массив, хранящий список 
###   покупок, пересоздавался в большем размере (такая структура данных 
###   называется «динамический массив»).