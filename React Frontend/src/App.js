import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from './Pages/Cart/Layout';
import NoPage from './Pages/Cart/NoPage';
import DisplayAllMobiles from './Components/Cart/DisplayAllMobiles'
import DisplayAllCustomers from './Components/Cart/DisplayAllCustomers';
import AddCartDTO from './Components/Cart/AddCartDTO';
import DeleteMobileFromCartDTO from './Components/Cart/DeleteMobileFromCartDTO';
import DisplayCustomerMobiles from './Components/Cart/DisplayCustomerMobiles';


function App() {
  return (
    <>
      <h1>Welcome to Online Mobile Application:</h1>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LayoutCart />}>
            <Route path="mobiles" element={<DisplayAllMobiles />} />
            <Route path="customers" element={<DisplayAllCustomers />} />
            <Route path="create" element={<AddCartDTO />}/>
            <Route path="delete" element={<DeleteMobileFromCartDTO />}/>
            <Route path="display" element={<DisplayCustomerMobiles/>}/>
            <Route path="*" element={<NoPage />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}
export default App;
