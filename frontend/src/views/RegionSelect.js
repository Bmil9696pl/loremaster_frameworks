import React from "react";
import '../style/App.css';
import runeterra from "../img/Runeterra_region.webp"
import demacia from "../img/Demacia_LoR_Region.webp"
import noxus from "../img/Noxus_LoR_Region.webp"


const RegionSelect = () => {
    return(
    <div className="App">
        <header className="App-header">
        <div className="select-text">
            <p className="stext">Select region:</p>
        </div>
        <div className="select-container">
            
            {/*<form
              style={{
                margin: 0,
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
                alignItems: 'center',
                width: '100%',
                height: '100%',
              }}
              action="regionselect"
              method="POST"
            >*/}
            <div className="select-container">
                <div className="region-button">
                    <img src={runeterra} alt="Runeterra" />
                    <button type="submit" name="runeterra">
                        Runeterra
                    </button>
                </div>
                <div className="region-button">
                    <img src={demacia} alt="Demacia" />
                    <button type="submit" name="demacia">
                        Demacia
                    </button>
                </div>
                <div className="region-button">
                    <img src={noxus} alt="Noxus" />
                    <button type="submit" name="noxus">
                        Noxus
                    </button>
                </div>
            </div>
            {/*</form>*/}
        </div>
        </header>
    </div>
    )
}

export default RegionSelect;