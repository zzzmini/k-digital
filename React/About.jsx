import "./About.css"
import { Outlet } from "react-router-dom";

function About(){
  return (
    <div>
      <div className="about_container">
          <h1>About SneakerShop</h1>
          <p>Welcome to SneakerShop, your ultimate destination for high-quality sneakers. Our mission is to provide top-notch footwear for every occasion.</p>
          <p>From sports performance shoes to casual lifestyle sneakers, we bring you the best selection from the world's leading brands.</p>
          <p>Shop with confidence and step up your sneaker game with us!</p>
          <div className="footer">&copy; 2025 SneakerShop. All rights reserved.</div>        
      </div>
      <div className="text-center">
        <Outlet></Outlet>
      </div>
    </div> 
  );
}

export default About;
