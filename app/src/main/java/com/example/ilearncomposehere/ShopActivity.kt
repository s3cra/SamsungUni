package com.example.ilearncomposehere

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.collections.plus
import kotlin.collections.plusAssign
import kotlin.inc
import kotlin.random.Random

//Задание 10
data class Cart(
    val products: List<Product>
)
data class Product(
    val id: Int,
    val name: String,
    val price: Int
)
class ShopActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartScreen()
        }
    }
    @Composable
    fun ShoppingCartScreen() {
        var products by remember {
            mutableStateOf(
                listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56)
                )
            )
        }
        val totalSum by remember { derivedStateOf {
            products.fold(0) { a,b -> a + b.price }
        } }
        val productSize by remember { derivedStateOf { products.size } }
        Column {
            for (product in products) {
                Text(text = product.name + " - " + product.price + " рублей")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "Товаров на сумму: $totalSum рублей")
            AddProductSection(totalSum) {
                products = products + Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(0, 100)
                )
            }
            RemoveProductSection(productSize) {
                products = products.dropLast(1)
            }
        }
    }
    @Composable
    fun AddProductSection(
        totalSum: Int,
        onAdd: () -> Unit
    ) {
        // Если сумма заказа больше 500, то показываем сообщение о бесплатной доставке
        if (totalSum > 500) {
            Toast.makeText(LocalContext.current, "Доставка бесплатная!",
                Toast.LENGTH_SHORT).show()
        }
        Button(onClick = onAdd) {
            Text(text = "Добавить товар")
        }
    }
    @Composable
    fun RemoveProductSection(
        productSize: Int,
        onRemove: () -> Unit
    ) {
        if (productSize > 0) {
            Button(onClick = onRemove) {
                Text(text = "Удалить товар")
            }
        }
    }
}