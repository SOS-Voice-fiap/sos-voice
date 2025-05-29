// 📩 Validação do formulário de contato
function validarFormulario() {
  const nome = document.getElementById("nome").value.trim();
  const email = document.getElementById("email").value.trim();
  const mensagem = document.getElementById("mensagem").value.trim();
  const retorno = document.getElementById("mensagemRetorno");

  if (nome === "" || email === "" || mensagem === "") {
    retorno.textContent = "Por favor, preencha todos os campos.";
    retorno.style.color = "red";
    return false;
  }

  retorno.textContent = "Mensagem enviada com sucesso!";
  retorno.style.color = "green";
  return false; // Evita envio real do formulário no protótipo
}

// ❓ Interatividade para perguntas da FAQ (acordeão)
document.addEventListener("DOMContentLoaded", () => {
  const botoesFAQ = document.querySelectorAll(".faq-question");
  botoesFAQ.forEach(botao => {
    botao.addEventListener("click", () => {
      const resposta = botao.nextElementSibling;
      resposta.classList.toggle("open");
    });
  });
});

// 🚨 Simulação de alertas (com voz TTS do navegador)
function simularAlerta(tipo) {
  const mensagem = document.getElementById("mensagemAlerta");
  let texto = "";

  switch (tipo) {
    case "enchente":
      texto = "Atenção: risco de enchente. Suba imediatamente para áreas mais altas e evite contato com a água!";
      break;
    case "deslizamento":
      texto = "Alerta de deslizamento! Evacue a área e dirija-se ao abrigo mais próximo indicado pela Defesa Civil.";
      break;
    case "incendio":
      texto = "Incêndio detectado nas proximidades. Mantenha distância, siga a rota de evacuação e aguarde instruções.";
      break;
  }

  mensagem.innerHTML = `<p><strong>Mensagem:</strong> ${texto}</p>`;

  // TTS (voz automática do navegador)
  const fala = new SpeechSynthesisUtterance(texto);
  speechSynthesis.speak(fala);
}
