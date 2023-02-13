package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.homework4.Algorithm;
public class MainActivity extends AppCompatActivity {

    // создание полей для вывода на экран нужных значений
    public EditText ticketNumberIn; // поле ввода номера билета
    public Button button; // кнопка обработки информации
    public TextView ticketInfoOut; // поле вывода результирующей информации

    // создание поля для алгоритма
    public String ticketNumber; // переменная для записи входного значения

    // создадим объект нашего алгоритма, чтобы мы могли получить доступ к его методам
    Algorithm algorithm = new Algorithm();
    // Номер билета
    int numTicket = 123456;

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        ticketNumberIn = findViewById(R.id.ticketNumberIn); // поле ввода
        button = findViewById(R.id.button); // кнопка обработки
        ticketInfoOut = findViewById(R.id.ticketInfoOut); // поле вывода

        // выполнение действий при нажании кнопки
        button.setOnClickListener(listener); // обработка нажатия кнопки
    }

    // объект обработки нажатия кнопки
    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            // считывание введённого значения
            ticketNumber = ticketNumberIn.getText().toString();

            // использование алгоритма для определения счастливого билета
            if (algorithm.checkTicket(numTicket)){ // если номер билета счастливый, то об этом выводится информация на экран
                ticketInfoOut.setText("Данный номер билета СЧАСТЛИВЫЙ " + algorithm.getLuckyTicket(numTicket));
            }
            else { // иначе, производится поиск данного билета с последующим выводом на экран
                ticketInfoOut.setText("Данный номер билета НЕ счастливый, следующим СЧАСТЛИВЫМ номером является "
                        + algorithm.getLuckyTicket(numTicket));
            }
        }
    };
}