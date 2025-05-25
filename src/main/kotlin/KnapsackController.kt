data class Item(val name: String, val weight: Int, val value: Int)

class KnapsackController {
    private val items = mutableListOf<Item>()
    private var capacity = 0

    fun addItem(name: String, weight: Int, value: Int) {
        items.add(Item(name, weight, value))
    }

    fun setCapacity(value: Int) {
        capacity = value
    }

    fun solve(): Pair<Int, List<Item>> {
        val n = items.size
        val dp = Array(n + 1) { IntArray(capacity + 1) }

        for (i in 1..n) {
            for (w in 0..capacity) {
                dp[i][w] = if (items[i - 1].weight <= w) {
                    maxOf(
                        items[i - 1].value + dp[i - 1][w - items[i - 1].weight],
                        dp[i - 1][w]
                    )
                } else {
                    dp[i - 1][w]
                }
            }
        }

        val selectedItems = mutableListOf<Item>()
        var w = capacity
        for (i in n downTo 1) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems.add(items[i - 1])
                w -= items[i - 1].weight
            }
        }

        return Pair(dp[n][capacity], selectedItems)
    }
}