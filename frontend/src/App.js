import Question from './views/Question';
import LoginScreen from './views/LoginScreen';
import HomeScreen from './views/HomeScreen';
import RegionSelect from './views/RegionSelect';
import RegistrationScreen from './views/RegistrationScreen';
import Leaderboard from './views/Leaderboard';
import {Route, Routes} from 'react-router-dom';

function App(){
    return (
        <Routes>
            <Route exact path='/' element={<LoginScreen/>} />
            <Route exact path='/login' element={<LoginScreen/>} />
            <Route exact path='/home' element={<HomeScreen/>} />
            <Route exact path='/question' element={<Question/>} />
            <Route exact path='/regionselect' element={<RegionSelect/>} />
            <Route exact path='/register' element={<RegistrationScreen/>}/>
            <Route exact path='/leaders' element={<Leaderboard/>}/>
        </Routes>
    );
}

export default App;