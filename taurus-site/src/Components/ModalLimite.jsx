import * as React from 'react';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import Modal from '@mui/material/Modal';
import FormLimite from './FormLimite';


export default function ModalLimite() {
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <Button onClick={handleOpen}>Cadastrar Limite</Button>
      <Modal
        open={open}
        onClose={handleClose}
        
      >
        <Box className='Modal-lancamento'>
            <FormLimite />
        </Box>
      </Modal>
    </div>
  );
}
