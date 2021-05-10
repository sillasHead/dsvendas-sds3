import DashBoard from 'pages/dash-board';
import Home from 'pages/home';
import { BrowserRouter, Route, Switch} from 'react-router-dom';

export default function Routes() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact>
          <Home />
        </Route>
        <Route path="/dash-board" exact>
          <DashBoard />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}
