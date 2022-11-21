import React, {useState} from 'react';

function Gasto(props) {

  const [gasto, setGasto] = useState(props.value);


  return(
      <>
        
                  <div>
                      <span className='spent-value'>R$ {gasto}</span>
                  </div>
            
      </>
  );
}

export default Gasto;