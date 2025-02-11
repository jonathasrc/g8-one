//O principal objetivo deste desafio é fortalecer suas habilidades em lógica de programação. Aqui você deverá desenvolver a lógica para resolver o problema.
let friends = [];


function addFriend(name) {
  if (!name || typeof name !== "string") {
    console.log("Nome inválido");
    return;
  }

  if (friends.includes(name)) {
    console.log(`${name} já está na lista de amigos.`);
    return;
  }

  friends.push(name);
  console.log(`${name} foi adicionado à lista de amigos.`);
  updateFriendList();
}

function listFriends() {
  console.log("Lista de amigos:", friends);
}

document.getElementById("addFriendButton").addEventListener("click", function() {
  const nameInput = document.querySelector("#amigo");
  const name = nameInput.value.trim();
  
  if (!name) {
    alert('Por favor, insira um nome')
    return;
  }
  
  addFriend(name);
  listFriends();
  nameInput.value = "";
  
});

function updateFriendList() {
  const friendListElement = document.getElementById("listaAmigos");
  friendListElement.innerHTML = "";
  friends.forEach(friend => {
    const li = document.createElement("li");
    li.textContent = friend;
    friendListElement.appendChild(li);
  });
}

function randomFriend() {
  if (friends.length === 0) {
    console.log("A lista de amigos está vazia.");
    document.getElementById("result").innerHTML = "Nenhum amigo disponível.";
    return null;
  }
  const randomIndex = Math.floor(Math.random() * friends.length);
  const selectedFriend = friends[randomIndex];
  console.log(`Amigo selecionado: ${selectedFriend}`);
  document.getElementById("resultado").innerHTML = `Amigo sorteado: ${selectedFriend}`;
  return selectedFriend;
}

document.getElementById("friendButton").addEventListener("click", function() {
  randomFriend();
  friends = [];
  
  const friendListElement = document.getElementById("listaAmigos");
  friendListElement.innerHTML = "";

});