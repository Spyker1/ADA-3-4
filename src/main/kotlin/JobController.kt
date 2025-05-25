data class Job(val name: String, val hours: Int, val profit: Int)

class JobController {
    private val jobs = mutableListOf<Job>()
    private var totalTime = 0

    fun addJob(name: String, hours: Int, profit: Int) {
        jobs.add(Job(name, hours, profit))
    }

    fun setTimeLimit(time: Int) {
        totalTime = time
    }

    fun getJobs(): List<Job> = jobs

    fun solve(): List<Job> {
        if (totalTime == 0) {
            return jobs.sortedByDescending { it.profit.toDouble() / it.hours }
        }

        val n = jobs.size
        val dp = Array(n + 1) { IntArray(totalTime + 1) }

        for (i in 1..n) {
            for (t in 0..totalTime) {
                val job = jobs[i - 1]
                dp[i][t] = if (job.hours <= t) {
                    maxOf(
                        job.profit + dp[i - 1][t - job.hours],
                        dp[i - 1][t]
                    )
                } else {
                    dp[i - 1][t]
                }
            }
        }

        val selected = mutableListOf<Job>()
        var t = totalTime
        for (i in n downTo 1) {
            if (dp[i][t] != dp[i - 1][t]) {
                selected.add(jobs[i - 1])
                t -= jobs[i - 1].hours
            }
        }

        return selected.reversed()
    }
}