"""first migrate

Revision ID: 759b89c2ac15
Revises: f72e1f3cabce
Create Date: 2024-06-24 19:15:21.489775

"""
from typing import Sequence, Union

from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision: str = '759b89c2ac15'
down_revision: Union[str, None] = 'f72e1f3cabce'
branch_labels: Union[str, Sequence[str], None] = None
depends_on: Union[str, Sequence[str], None] = None


def upgrade() -> None:
    pass


def downgrade() -> None:
    pass
