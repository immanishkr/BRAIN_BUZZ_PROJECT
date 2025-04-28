let questions = [];

window.onload = function () {
    fetch("/quiz/questions")
        .then(response => response.json())
        .then(data => {
            questions = data;
            let form = document.getElementById("quizForm");
            questions.forEach((q, index) => {
                let html = `<div>
                    <p>${index + 1}. ${q.questionText}</p>
                    <input type="radio" name="q${index}" value="${q.optionA}" required> ${q.optionA}<br>
                    <input type="radio" name="q${index}" value="${q.optionB}"> ${q.optionB}<br>
                    <input type="radio" name="q${index}" value="${q.optionC}"> ${q.optionC}<br>
                    <input type="radio" name="q${index}" value="${q.optionD}"> ${q.optionD}<br>
                </div><br>`;
                form.innerHTML += html;
            });
        });
};

function submitQuiz() {
    const userAnswers = [];
    questions.forEach((q, index) => {
        const selected = document.querySelector(`input[name="q${index}"]:checked`);
        userAnswers.push(selected ? selected.value : "");
    });

    fetch("/quiz/submit", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(userAnswers)
    })
    .then(res => res.json())
    .then(score => {
        document.getElementById("scoreDisplay").innerText = `Your Score: ${score} / ${questions.length}`;
    });
}
