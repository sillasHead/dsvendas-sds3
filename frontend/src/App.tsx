import DataTable from 'components/data-table';
import Footer from 'components/footer';
import Navbar from 'components/navbar';

function App() {
  return (
    <>
      <Navbar />
      <div className="container">
        <h1 className="text-primary">Olá mundo</h1>

        <DataTable />
      </div>
      <Footer />
    </>
  );
}

export default App;
