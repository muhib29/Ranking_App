const searchBtn = document.getElementById('searchBtn');
const seatInput = document.getElementById('seatInput');
const resultDiv = document.getElementById('result');
const notFoundDiv = document.getElementById('notFound');
const studentName = document.getElementById('studentName');
const marks = document.getElementById('marks');
const rank = document.getElementById('rank');

searchBtn.addEventListener('click', () => {
  const seatNo = seatInput.value.trim();
  if (!seatNo) return;

  fetch(`/api/students/${seatNo}`)
    .then(res => res.json())
    .then(data => {
      if (data.message) {
        notFoundDiv.style.display = 'block';
        resultDiv.style.display = 'none';
      } else {
        studentName.textContent = data.name;
        marks.textContent = data.marks;
        rank.textContent = data.rank;
        resultDiv.style.display = 'block';
        notFoundDiv.style.display = 'none';
      }
    })
    .catch(err => {
      console.error(err);
      notFoundDiv.style.display = 'block';
      resultDiv.style.display = 'none';
    });
});

seatInput.addEventListener('keypress', (e) => {
  if (e.key === 'Enter') {
    e.preventDefault();
    searchBtn.click();
  }
});
