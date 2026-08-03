// ====================================================================
// PURE SMILE — Lógica do tema claro/escuro
// --------------------------------------------------------------------
// init() = configuração inicial: acha os elementos, sincroniza o estado
// e liga os eventos. Roda UMA vez, no início.
// ====================================================================

function init() {

    // --- Acha os elementos no DOM (existem, pois o script roda no fim do body) ---
    const botao = document.querySelector('[data-action="toggle-tema"]');
    const atual = document.querySelector('[data-theme-icon]');

    // --- Sincroniza o ícone com o tema já aplicado pelo <head> ---
    // Sem isso, uma página escura mostraria a lua até o primeiro clique.
    atual.className = document.documentElement.getAttribute('data-theme') === 'dark' ? 'ri-sun-line' : 'ri-moon-line';

    // --- Liga o clique do botão: lê, inverte, aplica e salva ---
    botao.addEventListener('click', function () {
        const temaAtual = document.documentElement.getAttribute('data-theme');
        const novoTema = temaAtual === 'light' ? 'dark' : 'light';

        document.documentElement.setAttribute('data-theme', novoTema);
        localStorage.setItem('ps-tema', novoTema);
        atual.className = novoTema === 'dark' ? 'ri-sun-line' : 'ri-moon-line';
    });
}

// Roda o init quando a página termina de carregar o DOM.
// Assim o script funciona em qualquer posição do HTML (head ou body).
document.addEventListener('DOMContentLoaded', init);
