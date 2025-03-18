package com.example.lab2

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var container: LinearLayout
    private var selectedButton: Button? = null // Переменная для хранения выбранной кнопки
    private lateinit var infoText: TextView // Для управления начальным текстом
    private var buttonCount = 0 // Счетчик кнопок

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        container = findViewById(R.id.container)
        infoText = findViewById(R.id.info_text)
        // Больше не добавляем кнопку при старте
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add -> {
                addNewButton()
                true
            }
            R.id.menu_clear -> {
                container.removeAllViews()
                buttonCount = 0 // Сбрасываем счетчик кнопок
                infoText.visibility = View.VISIBLE // Показываем текст при очистке
                Toast.makeText(this, "Экран очищен", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_exit -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun addNewButton() {
        val newButton = Button(this).apply {
            buttonCount++ // Увеличиваем счетчик кнопок
            text = "Новый компонент $buttonCount"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 16, 0, 16) // Добавляем отступы между кнопками
            }
            setOnLongClickListener {
                selectedButton = this
                Toast.makeText(this@MainActivity, "Долгое нажатие", Toast.LENGTH_SHORT).show()
                openContextMenu(this)
                true
            }
            registerForContextMenu(this) // Регистрируем для контекстного меню
        }

        if (container.childCount == 1 && container.getChildAt(0) is TextView) {
            infoText.visibility = View.GONE // Скрываем текст при добавлении первой кнопки
        }
        container.addView(newButton)
        Toast.makeText(this, "Компонент добавлен", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v is Button) {
            selectedButton = v
            menuInflater.inflate(R.menu.context_menu, menu)
            menu?.setHeaderTitle("Выберите цвет")
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        selectedButton?.let { button ->
            when (item.itemId) {
                R.id.context_red -> button.setBackgroundColor(resources.getColor(android.R.color.holo_red_light))
                R.id.context_blue -> button.setBackgroundColor(resources.getColor(android.R.color.holo_blue_light))
                R.id.context_green -> button.setBackgroundColor(resources.getColor(android.R.color.holo_green_light))
            }
            return true
        }
        return super.onContextItemSelected(item)
    }
}