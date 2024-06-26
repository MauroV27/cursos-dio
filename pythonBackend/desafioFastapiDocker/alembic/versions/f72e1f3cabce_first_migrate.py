"""first migrate

Revision ID: f72e1f3cabce
Revises: 613f19c492b5
Create Date: 2024-06-24 17:46:51.308709

"""
from typing import Sequence, Union

from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision: str = 'f72e1f3cabce'
down_revision: Union[str, None] = '613f19c492b5'
branch_labels: Union[str, Sequence[str], None] = None
depends_on: Union[str, Sequence[str], None] = None


def upgrade() -> None:
    pass


def downgrade() -> None:
    pass
