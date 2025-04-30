import React, { useState } from "react";
import axios from "axios";
import './Chatbot.css'


const Chatbot = () => {
  // 사용자 입력과 대화 내용을 저장하는 상태 변수
  const [userInput, setUserInput] = useState("");
  const [messages, setMessages] = useState([]);

  // 사용자가 메시지를 입력했을 때 호출되는 함수
  const handleInputChange = (e) => {
    setUserInput(e.target.value);
  };

  // 사용자가 메시지를 전송했을 때 호출되는 함수
  const handleSendMessage = async () => {
    if (userInput.trim()) {
      // 사용자 메시지 추가
      setMessages([...messages, { text: userInput, sender: "user" }]);
      
      // API 요청 보내기 (FastAPI에 질문을 전달)
      try {
        const response = await axios.post("http://127.0.0.1:8000/answer", {
          question: userInput
        });

        // 챗봇의 답변 추가
        setMessages([
          ...messages,
          { text: userInput, sender: "user" },
          { text: response.data, sender: "bot" }
        ]);
        console.log('respons data:' + response.data)
      } catch (error) {
        console.error("Error:", error);
      }
      
      // 입력창 초기화
      setUserInput("");
    }
  };

  return (
    <div className="chatbot">
      <div className="chat-window">
        <div className="messages">
          {messages.map((msg, index) => (
            <div key={index} className={msg.sender}>
              <span>{msg.text}</span>
            </div>
          ))}
        </div>
      </div>
      
      <div className="input-area">
        <input
          type="text"
          value={userInput}
          onChange={handleInputChange}
          placeholder="Ask me something..."
        />
        <button onClick={handleSendMessage}>Send</button>
      </div>
    </div>
  );
};

export default Chatbot;
